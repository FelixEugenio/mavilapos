package com.mavila.pos.entity.cashRegister;

import com.mavila.pos.entity.cashRegister.enums.CashierStatus;
import com.mavila.pos.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CashRegister implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime openedAt;

    private LocalDateTime closedAt;

    private BigDecimal openingAmount;

    private BigDecimal closingAmount;

    @Enumerated(EnumType.STRING)
    private CashierStatus status;

    @ManyToOne
    private User openedBy;
}
