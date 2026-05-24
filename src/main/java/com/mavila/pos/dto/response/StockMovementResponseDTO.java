package com.mavila.pos.dto.response;

import com.mavila.pos.entity.stockMovement.enums.stockMovementType;

import java.time.LocalDateTime;

public record StockMovementResponseDTO(
        Long id,
        String product,
        stockMovementType type,
        Integer quantity,
        String reason,
        LocalDateTime createdAt
) {
}
