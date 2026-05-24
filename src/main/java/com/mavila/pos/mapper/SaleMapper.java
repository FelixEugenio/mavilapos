package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.response.SaleItemResponseDTO;
import com.mavila.pos.dto.response.SaleResponseDTO;
import com.mavila.pos.entity.Sale.Sale;
import com.mavila.pos.entity.SaleItem.SaleItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface SaleMapper {
    @Mapping(target = "cashier", source = "cashier.name")
    SaleResponseDTO toResponse(Sale entity);

    @Mapping(target = "product", source = "product.name")
    SaleItemResponseDTO toItemResponse(SaleItem entity);
}
