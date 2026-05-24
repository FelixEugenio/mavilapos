package com.mavila.pos.dto.response;

public record LoginResponseDTO(
        String token,
        String type
) {
}
