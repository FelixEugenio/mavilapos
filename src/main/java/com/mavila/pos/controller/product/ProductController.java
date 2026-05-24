package com.mavila.pos.controller.product;

import com.mavila.pos.dto.request.ProductRequestDTO;
import com.mavila.pos.dto.response.ProductResponseDTO;
import com.mavila.pos.service.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Products", description = "Gerenciamento de produtos")
@SecurityRequirement(name = "bearerAuth")
public class ProductController {

    @Autowired
    private final ProductService service;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> create(
            @Valid @RequestBody ProductRequestDTO dto
    ) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> findAll(
            @PageableDefault(size = 10, sort = "id") Pageable pageable
    ) {
        return ResponseEntity.ok((Page<ProductResponseDTO>) service.findAll(pageable));
    }

}
