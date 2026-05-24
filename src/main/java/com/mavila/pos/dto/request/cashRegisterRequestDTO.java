package com.mavila.pos.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record cashRegisterRequestDTO(
        @NotNull
        BigDecimal openingAmount
) {
}
