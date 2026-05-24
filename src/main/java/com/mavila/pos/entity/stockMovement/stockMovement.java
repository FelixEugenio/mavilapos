package com.mavila.pos.entity.stockMovement;

import com.mavila.pos.entity.product.Product;
import com.mavila.pos.entity.stockMovement.enums.stockMovementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class stockMovement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Enumerated(EnumType.STRING)
    private stockMovementType type;

    private Integer quantity;

    private String reason;

    private LocalDateTime createdAt;
}
