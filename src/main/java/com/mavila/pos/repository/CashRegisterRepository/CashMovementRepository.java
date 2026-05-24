package com.mavila.pos.repository.CashRegisterRepository;

import com.mavila.pos.entity.cashMovement.cashMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CashMovementRepository extends JpaRepository<cashMovement, Long> {
    List<cashMovement> findByCashRegisterId(Long cashRegisterId);
}
