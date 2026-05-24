package com.mavila.pos.service.sale;

import com.mavila.pos.dto.request.SaleItemRequestDTO;
import com.mavila.pos.dto.response.SaleResponseDTO;
import com.mavila.pos.entity.Sale.Sale;
import com.mavila.pos.entity.Sale.enums.PaymentMethod;
import com.mavila.pos.entity.Sale.enums.SaleStatus;
import com.mavila.pos.entity.SaleItem.SaleItem;
import com.mavila.pos.entity.product.Product;
import com.mavila.pos.entity.user.User;
import com.mavila.pos.mapper.SaleMapper;
import com.mavila.pos.repository.sale.SaleRepository;
import com.mavila.pos.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository repository;
    private final ProductService productService;
    private final SaleMapper mapper;
    private final StockMovementService stockMovementService;

    @Transactional
    public SaleResponseDTO create(
            List<SaleItemRequestDTO> items,
            PaymentMethod paymentMethod,
            User cashier
    ) {

        Sale sale = new Sale();

        sale.setCreatedAt(LocalDateTime.now());
        sale.setStatus(SaleStatus.COMPLETED);
        sale.setPaymentMethod(paymentMethod);
        sale.setCashier(cashier);

        List<SaleItem> saleItems = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for (SaleItemRequestDTO itemDTO : items) {

            Product product = productService.findEntityById(itemDTO.productId());

            BigDecimal subtotal = product.getPrice()
                    .multiply(BigDecimal.valueOf(itemDTO.quantity()));

            SaleItem item = new SaleItem();
            item.setSale(sale);
            item.setProduct(product);
            item.setQuantity(itemDTO.quantity());
            item.setUnitPrice(product.getPrice());
            item.setSubtotal(subtotal);

            saleItems.add(item);

            total = total.add(subtotal);

            productService.decreaseStock(product, itemDTO.quantity());

            stockMovementService.createOutMovement(
                    product,
                    itemDTO.quantity(),
                    "Sale"
            );
        }

        sale.setItems(saleItems);
        sale.setSubtotal(total);
        sale.setDiscount(BigDecimal.ZERO);
        sale.setTotal(total);

        Sale saved = repository.save(sale);

        return mapper.toResponse(saved);
    }
}
