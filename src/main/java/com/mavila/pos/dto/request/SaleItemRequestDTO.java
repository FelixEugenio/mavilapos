package com.mavila.pos.dto.request;

import jakarta.validation.constraints.NotNull;

public record SaleItemRequestDTO(
        @NotNull
        Long productId,

        @NotNull
        Integer quantity
) {
}
