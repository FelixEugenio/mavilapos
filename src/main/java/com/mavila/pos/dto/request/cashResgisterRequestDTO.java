package com.mavila.pos.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record cashResgisterRequestDTO(
        @NotNull
        BigDecimal openingAmount
) {
}
