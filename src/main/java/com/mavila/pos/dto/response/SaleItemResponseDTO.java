package com.mavila.pos.dto.response;

import java.math.BigDecimal;

public record SaleItemResponseDTO(
        Long id,
        String product,
        Integer quantity,
        BigDecimal unitPrice,
        BigDecimal subtotal
) {
}
