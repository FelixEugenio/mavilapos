package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.response.cashRegisterResponseDTO;
import com.mavila.pos.entity.cashRegister.CashRegister;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface CashRegisterMapper {
    @Mapping(target = "openedBy", source = "openedBy.name")
    cashRegisterResponseDTO toResponse(CashRegister entity);
}
