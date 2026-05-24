package com.mavila.pos.repository.sale;

import com.mavila.pos.entity.Sale.Sale;
import com.mavila.pos.entity.Sale.enums.SaleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByStatus(SaleStatus status);

    List<Sale> findByCreatedAtBetween(
            LocalDateTime start,
            LocalDateTime end
    );

    @Query("""
            SELECT COALESCE(SUM(s.total), 0)
            FROM Sale s
            WHERE DATE(s.createdAt) = :date
            AND s.status = 'COMPLETED'
            """)
    BigDecimal getTotalSalesByDate(LocalDate date);
}
