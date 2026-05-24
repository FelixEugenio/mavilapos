package com.mavila.pos.controller.sale;

import com.mavila.pos.dto.request.SaleRequestDTO;
import com.mavila.pos.dto.response.SaleResponseDTO;
import com.mavila.pos.entity.user.User;
import com.mavila.pos.service.sale.SaleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService service;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> create(
            @Valid @RequestBody SaleRequestDTO dto,
            Authentication authentication
    ) {

        User cashier = (User) authentication.getPrincipal();

        SaleResponseDTO response = service.create(
                dto.items(),
                dto.paymentMethod(),
                cashier
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
