package com.mavila.pos.config.Security;

public class SecurityConstants {
    public static final String[] PUBLIC_ROUTES = {
            "/api/auth/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    private SecurityConstants() {
    }
}
