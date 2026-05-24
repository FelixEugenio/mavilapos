package com.mavila.pos.controller.stock;

import com.mavila.pos.dto.response.StockMovementResponseDTO;
import com.mavila.pos.service.stock.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-movements")
@RequiredArgsConstructor
public class StockMovementController {
    private final StockMovementService service;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<StockMovementResponseDTO>> findByProduct(
            @PathVariable Long productId
    ) {

        return ResponseEntity.ok(service.findByProduct(productId));
    }
}
