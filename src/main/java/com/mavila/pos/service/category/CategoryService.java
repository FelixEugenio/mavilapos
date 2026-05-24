package com.mavila.pos.service.category;

import com.mavila.pos.dto.request.CategoryRequestDTO;
import com.mavila.pos.dto.response.CategoryResponseDTO;
import com.mavila.pos.entity.category.Category;
import com.mavila.pos.exception.BusinessException;
import com.mavila.pos.mapper.CategoryMapper;
import com.mavila.pos.repository.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final CategoryMapper categoryMapper;

    public CategoryResponseDTO create(CategoryRequestDTO dto) {

        if(categoryRepository.existsByNameIgnoreCase(dto.name())){
            throw new BusinessException("Category already exists");
        }

        Category category = categoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);

        return categoryMapper.toResponseDTO(saved);
    }

    public List<CategoryResponseDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponseDTO)
                .toList();
    }
}
