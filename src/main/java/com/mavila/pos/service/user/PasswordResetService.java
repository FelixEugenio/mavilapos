package com.mavila.pos.service.user;

import com.mavila.pos.dto.request.ForgotPasswordRequestDTO;
import com.mavila.pos.dto.request.ResetPasswordRequestDTO;
import com.mavila.pos.entity.user.PasswordResetToken;
import com.mavila.pos.entity.user.User;
import com.mavila.pos.exception.BusinessException;
import com.mavila.pos.repository.user.PasswordResetTokenRepository;
import com.mavila.pos.repository.user.UserRepository;
import com.mavila.pos.service.email.EmailService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class PasswordResetService {

    private final UserRepository userRepository;
    private final PasswordResetTokenRepository tokenRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.frontend.reset-password-url}")
    private String resetPasswordUrl;

    @Transactional
    public void forgotPassword(
            @Valid @NotNull ForgotPasswordRequestDTO dto
    ) {
        userRepository.findByEmail(dto.email())
                .ifPresent(user -> {
                    String token = UUID.randomUUID().toString();

                    PasswordResetToken resetToken = PasswordResetToken.builder()
                            .token(token)
                            .user(user)
                            .expiresAt(LocalDateTime.now().plusMinutes(30))
                            .used(false)
                            .build();

                    tokenRepository.save(resetToken);

                    String link = resetPasswordUrl + "?token=" + token;

                    emailService.sendPasswordResetEmail(
                            user.getEmail(),
                            user.getUsername(),
                            link
                    );
                });
    }

    @Transactional
    public void resetPassword(
            @Valid @NotNull ResetPasswordRequestDTO dto
    ) {
        PasswordResetToken resetToken = tokenRepository.findByToken(dto.token())
                .orElseThrow(() ->
                        new BusinessException("Invalid token")
                );

        if (Boolean.TRUE.equals(resetToken.getUsed())) {
            throw new BusinessException("Token already used");
        }

        if (resetToken.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Token expired");
        }

        User user = resetToken.getUser();

        user.setPassword(
                passwordEncoder.encode(dto.newPassword())
        );

        resetToken.setUsed(true);

        userRepository.save(user);
        tokenRepository.save(resetToken);
    }
}