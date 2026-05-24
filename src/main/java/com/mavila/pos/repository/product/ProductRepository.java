package com.mavila.pos.repository.product;

import com.mavila.pos.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByBarcode(String barcode);

    List<Product> findByActiveTrue();

    List<Product> findByStockLessThan(Integer stock);

    @Query("""
            SELECT p
            FROM Product p
            WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))
            """)
    List<Product> searchByName(String name);
}
