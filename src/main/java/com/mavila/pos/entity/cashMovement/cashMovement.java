package com.mavila.pos.entity.cashMovement;

import com.mavila.pos.entity.cashMovement.enums.CashMovementType;
import com.mavila.pos.entity.cashRegister.CashRegister;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class cashMovement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CashMovementType type;

    private BigDecimal amount;

    private String description;

    private LocalDateTime createdAt;

    @ManyToOne
    private CashRegister cashRegister;
}
