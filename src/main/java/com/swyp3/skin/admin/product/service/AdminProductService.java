package com.swyp3.skin.admin.product.service;

import com.swyp3.skin.admin.product.dto.AdminProductCreateForm;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long create(AdminProductCreateForm form){
        Product product = Product.create(
                form.name(),
                form.brand(),
                form.category(),
                form.description(),
                form.imageUrl(),
                form.purchaseUrl(),
                form.active()
        );
        return productRepository.save(product).getId();

    }
}
