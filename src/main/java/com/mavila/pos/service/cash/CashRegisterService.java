package com.mavila.pos.service.cash;

import com.mavila.pos.dto.request.cashRegisterRequestDTO;
import com.mavila.pos.dto.response.cashRegisterResponseDTO;
import com.mavila.pos.entity.cashRegister.CashRegister;
import com.mavila.pos.entity.cashRegister.enums.CashierStatus;
import com.mavila.pos.entity.user.User;
import com.mavila.pos.mapper.CashRegisterMapper;
import com.mavila.pos.repository.CashRegisterRepository.CashRegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CashRegisterService {

    @Autowired
    private final CashRegisterRepository repository;
    @Autowired
    private final CashRegisterMapper mapper;

    @Transactional
    public cashRegisterResponseDTO open(
            cashRegisterRequestDTO dto,
            User user
    ) {

        repository.findByStatus(CashierStatus.OPEN)
                .ifPresent(c -> {
                    throw new RuntimeException("Cash register already open");
                });

        CashRegister cash = new CashRegister();

        cash.setOpenedAt(LocalDateTime.now());
        cash.setOpeningAmount(dto.openingAmount());
        cash.setStatus(CashierStatus.OPEN);
        cash.setOpenedBy(user);

        CashRegister saved = repository.save(cash);

        return mapper.toResponse(saved);
    }

    @Transactional
    public cashRegisterResponseDTO close(Long id, BigDecimal amount) {{

        CashRegister cash = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cash register not found"));

        cash.setClosedAt(LocalDateTime.now());
        cash.setClosingAmount(amount);
        cash.setStatus(CashierStatus.CLOSE);

        CashRegister saved = repository.save(cash);

        return mapper.toResponse(saved);
    }
}

}

