package com.mavila.pos.dto.response;

import java.math.BigDecimal;

public record ProductResponseDTO (
        Long id,
        String name,
        String barcode,
        BigDecimal price,
        Integer stock,
        Integer minimumStock,
        String category
) {
}
