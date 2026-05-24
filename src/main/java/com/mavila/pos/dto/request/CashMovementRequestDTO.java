package com.mavila.pos.dto.request;

import com.mavila.pos.entity.cashMovement.enums.CashMovementType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CashMovementRequestDTO(
        @NotNull
        CashMovementType type,

        @NotNull
        BigDecimal amount,

        String description
) {
}
