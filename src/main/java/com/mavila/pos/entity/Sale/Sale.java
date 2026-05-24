package com.mavila.pos.entity.Sale;

import com.mavila.pos.entity.Sale.enums.PaymentMethod;
import com.mavila.pos.entity.Sale.enums.SaleStatus;
import com.mavila.pos.entity.SaleItem.SaleItem;
import com.mavila.pos.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private BigDecimal subtotal;

    private BigDecimal total;

    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "sale",
            cascade = CascadeType.ALL)
    private List<SaleItem> items;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
