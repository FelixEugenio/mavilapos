package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.response.CashMovementResponseDTO;
import com.mavila.pos.entity.cashMovement.cashMovement;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface CashMovementMapper {

    CashMovementResponseDTO toResponse(cashMovement entity);;
}
