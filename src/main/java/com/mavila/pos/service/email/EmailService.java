package com.mavila.pos.service.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    public void sendPasswordResetEmail(
            String to,
            String name,
            String resetLink
    ) {
        try {
            Context context = new Context();
            context.setVariable("name", name);
            context.setVariable("resetLink", resetLink);

            String html = templateEngine.process(
                    "emails/reset-password",
                    context
            );

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(
                    message,
                    true,
                    "UTF-8"
            );

            helper.setTo(to);
            helper.setSubject("Recuperação de Senha");
            helper.setText(html, true);

            mailSender.send(message);
        } catch (MessagingException | MailException e) {
            throw new RuntimeException("Failed to send password reset email", e);
        }
    }
}