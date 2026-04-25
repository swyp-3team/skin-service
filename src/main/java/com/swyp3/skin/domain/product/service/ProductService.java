package com.swyp3.skin.domain.product.service;

import com.swyp3.skin.api.v1.product.dto.response.ProductSearchResult;
import com.swyp3.skin.domain.common.pagination.SliceResult;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.exception.ProductErrorCode;
import com.swyp3.skin.domain.product.domain.exception.ProductException;
import com.swyp3.skin.domain.product.repository.ProductRepository;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
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

    public List<RecommendedProduct> filter(
            List<RecommendedProduct> recommended,
            List<String> categories) {
        if (categories == null || categories.isEmpty()) {
            return recommended;
        }

        return recommended.stream()
                .filter(product -> categories.stream()
                        .anyMatch(c -> product.getProduct()
                                .getCategory()
                                .name().
                                equalsIgnoreCase(c)))
                .toList();
    }

    public SliceResult<RecommendedProduct> sliceWithCursor(
            List<RecommendedProduct> filtered,
            Long cursor,
            int size) {
        int startIndex = 0;

        if (cursor != null) {
            // O(n)임 개선필요
            for (int i = 0; i < filtered.size(); i++) {
                if (filtered.get(i).getProduct().getId().equals(cursor)) {
                    startIndex = i + 1;
                    break;
                }
            }
        }

        List<RecommendedProduct> sliced = filtered.stream()
                .skip(startIndex)
                .limit(size)
                .toList();

        boolean hasNext = sliced.size() > startIndex + size;

        return new SliceResult<>(sliced, hasNext);
    }

}
