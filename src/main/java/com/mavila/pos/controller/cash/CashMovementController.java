package com.mavila.pos.controller.cash;

import com.mavila.pos.dto.request.CashMovementRequestDTO;
import com.mavila.pos.dto.response.CashMovementResponseDTO;
import com.mavila.pos.entity.cashRegister.CashRegister;
import com.mavila.pos.service.cash.CashMovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cash-movements")
@RequiredArgsConstructor
public class CashMovementController {
    private final CashMovementService service;

    @PostMapping
    public ResponseEntity<CashMovementResponseDTO> create(
            @Valid @RequestBody CashMovementRequestDTO dto,
            @RequestAttribute CashRegister cashRegister
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto, cashRegister));
    }

    @GetMapping("/cash-register/{cashId}")
    public ResponseEntity<List<CashMovementResponseDTO>> findByCashRegister(
            @PathVariable Long cashId
    ) {

        return ResponseEntity.ok(service.findByCashRegister(cashId));
    }
}
