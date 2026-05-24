package com.mavila.pos.dto.request;

import com.mavila.pos.entity.Sale.enums.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record SaleRequestDTO(
        @NotEmpty
        List<SaleItemRequestDTO> items,

        BigDecimal discount,

        @NotNull
        PaymentMethod paymentMethod
) {
}
