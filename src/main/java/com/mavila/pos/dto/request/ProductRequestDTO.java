package com.mavila.pos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRequestDTO (
        @NotBlank
        String name,

        String barcode,

        @NotNull
        BigDecimal price,

        @NotNull
        Integer stock,

        Integer minimumStock,

        Long categoryId
) {

}
