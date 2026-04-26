package com.swyp3.skin.domain.product.service;

import com.swyp3.skin.api.v1.product.dto.response.ProductSummaryResponse;
import com.swyp3.skin.domain.common.pagination.CursorPaginationUtils;
import com.swyp3.skin.domain.common.pagination.SliceResult;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.exception.ProductErrorCode;
import com.swyp3.skin.domain.product.domain.exception.ProductException;
import com.swyp3.skin.domain.product.repository.ProductRepository;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import com.swyp3.skin.recommendation.ux.SkinProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SkinProfileService skinProfileService;

    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_NOT_FOUND));
    }

    public SliceResult<ProductSummaryResponse> search(String keyword, int cursor, int size) {
        SliceResult<Product> slice =
                CursorPaginationUtils.sliceWithCursor(productRepository.search(keyword),
                        cursor,
                        size,
                        Product::getId);

        List<ProductSummaryResponse> dtoList = slice.items().stream()
                .map(ProductSummaryResponse::from)
                .toList();


        return new SliceResult<>(dtoList, slice.hasNext());
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

        boolean hasNext = filtered.size() > startIndex + size;

        return new SliceResult<>(sliced, hasNext);
    }

}
