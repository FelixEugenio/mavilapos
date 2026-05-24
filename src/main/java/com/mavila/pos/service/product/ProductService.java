package com.mavila.pos.service.product;

import com.mavila.pos.dto.request.ProductRequestDTO;
import com.mavila.pos.dto.response.ProductResponseDTO;
import com.mavila.pos.entity.category.Category;
import com.mavila.pos.entity.product.Product;
import com.mavila.pos.mapper.ProductMapper;
import com.mavila.pos.repository.category.CategoryRepository;
import com.mavila.pos.repository.product.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    @Autowired
    private final ProductRepository repository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ProductMapper mapper;

    @Transactional
    public ProductResponseDTO save(ProductRequestDTO dto){
        Product product = mapper.toEntity(dto);

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCategory(category);

        Product saved = repository.save(product);

        return mapper.toResponse(saved);
    }

    public List<ProductResponseDTO> findAll() {
        return repository.findByActiveTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Product findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Transactional
    public void decreaseStock(Product product, Integer quantity) {

        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock");
        }

        product.setStock(product.getStock() - quantity);

        repository.save(product);
    }
}
