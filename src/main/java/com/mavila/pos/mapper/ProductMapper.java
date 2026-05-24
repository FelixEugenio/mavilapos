package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.request.ProductRequestDTO;
import com.mavila.pos.dto.response.ProductResponseDTO;
import com.mavila.pos.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "active", constant = "true")
    Product toEntity(ProductRequestDTO dto);

    @Mapping(target = "category", source = "category.name")
    ProductResponseDTO toResponse(Product entity);
}
