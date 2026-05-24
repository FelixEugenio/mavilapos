package com.mavila.pos.dto.response;

import com.mavila.pos.entity.Sale.enums.PaymentMethod;
import com.mavila.pos.entity.Sale.enums.SaleStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponseDTO (
        Long id,
        LocalDateTime createdAt,
        BigDecimal subtotal,
        BigDecimal discount,
        BigDecimal total,
        PaymentMethod paymentMethod,
        SaleStatus status,
        String cashier,
        List<SaleItemResponseDTO> items
) {
}
