package com.swyp3.skin.domain.product.service;

import com.swyp3.skin.api.v1.product.dto.response.ProductSearchResult;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.exception.ProductErrorCode;
import com.swyp3.skin.domain.product.domain.exception.ProductException;
import com.swyp3.skin.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND));
    }

    public ProductSearchResult search(String keyword, int page, int size) {
        List<Product> productList = productRepository.search(keyword);

        List<Product> sliced = productList.stream()
                .skip((long) page * size)
                .limit(size)
                .toList();

        boolean hasNext = productList.size() > (page + 1) * size;

        return new ProductSearchResult(sliced, hasNext);
    }
}
