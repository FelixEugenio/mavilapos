package com.mavila.pos.controller.cash;

import com.mavila.pos.dto.request.cashRegisterRequestDTO;
import com.mavila.pos.dto.response.cashRegisterResponseDTO;
import com.mavila.pos.entity.user.User;
import com.mavila.pos.service.cash.CashRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/cash-registers")
@RequiredArgsConstructor
public class CashRegisterController {
    private final CashRegisterService service;

    @PostMapping("/open")
    public ResponseEntity<cashRegisterResponseDTO> open(
            @Valid @RequestBody cashRegisterRequestDTO dto,
            Authentication authentication
    ) {

        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(service.open(dto, user));
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<cashRegisterResponseDTO> close(
            @PathVariable Long id,
            @RequestParam BigDecimal amount
    ) {

        return ResponseEntity.ok(service.close(id, amount));
    }
}
