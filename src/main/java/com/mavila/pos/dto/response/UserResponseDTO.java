package com.mavila.pos.dto.response;

import com.mavila.pos.entity.user.enums.Role;

public record UserResponseDTO(
        Long id,
        String name,
        String username,
        Role role,
        Boolean active
) {
}
