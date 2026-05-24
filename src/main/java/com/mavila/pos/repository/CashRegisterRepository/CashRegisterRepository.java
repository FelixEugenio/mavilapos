package com.mavila.pos.repository.CashRegisterRepository;

import com.mavila.pos.entity.cashRegister.CashRegister;
import com.mavila.pos.entity.cashRegister.enums.CashierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, Long> {
    Optional<CashRegister> findByStatus(CashierStatus status);
}
