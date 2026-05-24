package com.mavila.pos.repository.stock;

import com.mavila.pos.entity.stockMovement.stockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMovementRepository extends JpaRepository<stockMovement, Long> {
    List<stockMovement> findByProductId(Long productId);
}
