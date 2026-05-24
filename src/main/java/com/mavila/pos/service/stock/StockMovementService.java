package com.mavila.pos.service.stock;

import com.mavila.pos.dto.response.StockMovementResponseDTO;
import com.mavila.pos.entity.product.Product;
import com.mavila.pos.entity.stockMovement.enums.stockMovementType;
import com.mavila.pos.entity.stockMovement.stockMovement;
import com.mavila.pos.mapper.StockMovementMapper;
import com.mavila.pos.repository.stock.StockMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockMovementService {

    @Autowired
    private final StockMovementRepository repository;

    @Autowired
    private final StockMovementMapper mapper;

    public void createOutMovement(
            Product product,
            Integer quantity,
            String reason
    ) {

        stockMovement movement = new stockMovement();

        movement.setProduct(product);
        movement.setType(stockMovementType.OUT);
        movement.setQuantity(quantity);
        movement.setReason(reason);
        movement.setCreatedAt(LocalDateTime.now());

        repository.save(movement);
    }

    public void createInMovement(
            Product product,
            Integer quantity,
            String reason
    ) {

        stockMovement movement = new stockMovement();

        movement.setProduct(product);
        movement.setType(stockMovementType.IN);
        movement.setQuantity(quantity);
        movement.setReason(reason);
        movement.setCreatedAt(LocalDateTime.now());

        repository.save(movement);
    }

    public List<StockMovementResponseDTO> findByProduct(Long productId) {
        return repository.findByProductId(productId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
