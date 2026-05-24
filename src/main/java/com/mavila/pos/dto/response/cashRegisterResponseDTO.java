package com.mavila.pos.dto.response;

import com.mavila.pos.entity.cashRegister.enums.CashierStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record cashRegisterResponseDTO(
        Long id,
        LocalDateTime openedAt,
        LocalDateTime closedAt,
        BigDecimal openingAmount,
        BigDecimal closingAmount,
        CashierStatus status,
        String openedBy
) {
}
