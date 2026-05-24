package com.mavila.pos.service.auth;

import com.mavila.pos.dto.request.LoginRequestDTO;
import com.mavila.pos.dto.response.LoginResponseDTO;
import com.mavila.pos.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.username(),
                        dto.password()
                )
        );
        String token = jwtService.generateToken(dto.username());

        return new LoginResponseDTO(token, "Bearer");
    }
}
