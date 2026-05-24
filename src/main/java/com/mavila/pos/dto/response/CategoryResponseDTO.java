package com.mavila.pos.dto.response;

import jakarta.validation.constraints.NotBlank;

public record CategoryResponseDTO (
        Long id,
        String name
){
}
