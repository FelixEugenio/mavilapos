package com.mavila.pos.mapper;

import com.mavila.pos.config.MapStructConfig;
import com.mavila.pos.dto.request.CategoryRequestDTO;
import com.mavila.pos.dto.response.CategoryResponseDTO;
import com.mavila.pos.entity.category.Category;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface CategoryMapper {
    Category toEntity(CategoryRequestDTO dto);
    CategoryResponseDTO toResponseDTO(Category entity);
}
