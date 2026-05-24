package com.mavila.pos.dto.request;

import com.mavila.pos.entity.user.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO (
        @NotBlank
        String name,

        @NotBlank
        String username,

        @NotBlank
        String password,

        @NotNull
        Role role
) {
}
