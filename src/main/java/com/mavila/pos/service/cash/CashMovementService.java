package com.mavila.pos.service.cash;

import com.mavila.pos.dto.request.CashMovementRequestDTO;
import com.mavila.pos.dto.response.CashMovementResponseDTO;
import com.mavila.pos.entity.cashMovement.cashMovement;
import com.mavila.pos.entity.cashRegister.CashRegister;
import com.mavila.pos.mapper.CashMovementMapper;
import com.mavila.pos.repository.CashRegisterRepository.CashMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CashMovementService {

    @Autowired
    private final CashMovementRepository repository;

    @Autowired
    private final CashMovementMapper mapper;

    public CashMovementResponseDTO create(
            CashMovementRequestDTO dto,
            CashRegister cashRegister
    ) {

        cashMovement movement = new cashMovement();

        movement.setType(dto.type());
        movement.setAmount(dto.amount());
        movement.setDescription(dto.description());
        movement.setCashRegister(cashRegister);
        movement.setCreatedAt(LocalDateTime.now());

        cashMovement saved = repository.save(movement);

        return mapper.toResponse(saved);
    }

    public List<CashMovementResponseDTO> findByCashRegister(Long cashId) {
        return repository.findByCashRegisterId(cashId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
