package com.mavila.pos.dto.response;

import com.mavila.pos.entity.cashMovement.enums.CashMovementType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CashMovementResponseDTO(
        Long id,
        CashMovementType type,
        BigDecimal amount,
        String description,
        LocalDateTime createdAt
) {
}
