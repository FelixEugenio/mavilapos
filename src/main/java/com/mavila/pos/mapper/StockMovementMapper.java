package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.response.StockMovementResponseDTO;
import com.mavila.pos.entity.stockMovement.stockMovement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface StockMovementMapper {
    @Mapping(target = "product", source = "product.name")
    StockMovementResponseDTO toResponse(stockMovement entity);
}
