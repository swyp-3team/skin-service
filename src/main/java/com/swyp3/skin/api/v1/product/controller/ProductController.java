package com.swyp3.skin.api.v1.product.controller;

import com.swyp3.skin.api.v1.product.dto.response.ProductDetailResponse;
import com.swyp3.skin.api.v1.product.dto.response.ProductListResponse;
import com.swyp3.skin.api.v1.product.dto.response.ProductSearchResponse;
import com.swyp3.skin.api.v1.product.dto.response.ProductSearchResult;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.entity.ProductGroupScore;
import com.swyp3.skin.domain.product.domain.exception.ProductErrorCode;
import com.swyp3.skin.domain.product.domain.exception.ProductException;
import com.swyp3.skin.domain.product.service.ProductGroupScoreService;
import com.swyp3.skin.domain.product.service.ProductRecommendationFacade;
import com.swyp3.skin.domain.product.service.ProductService;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.service.SkinResultService;
import com.swyp3.skin.global.auth.CustomUserDetails;
import com.swyp3.skin.global.response.dto.ApiResponse;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import com.swyp3.skin.recommendation.product.service.ProductRecommendationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Product", description = "제품추천")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final SkinResultService skinResultService;
    private final ProductRecommendationFacade productRecommendationFacade;
    private final ProductRecommendationService productRecommendationService;

    @Operation(summary = "추천 제품 조회")
    @GetMapping("/recommend")
    public ApiResponse<ProductListResponse> recommend(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestParam(required = false) List<String> categories,
            @RequestParam(required = false) Long skinResultId,
            @RequestParam Long cursor,
            @RequestParam int size
            ) {
        Long userId = userDetails.userId();

        ProductListResponse response = productRecommendationFacade.getRecommendedProducts(
                userId,
                skinResultId,
                categories,
                cursor,
                size
        );
        return ApiResponse.ok(response);
    }

    @Operation(
            summary = "제품 상세 조회",
            description = "특정 제품의 상세 정보와 포함 성분 정보를 조회합니다."
    )
    @GetMapping("/{productId}")
    public ApiResponse<ProductDetailResponse> getDetail(
            @PathVariable Long productId) {

        Product product = productService.getById(productId);

        ProductDetailResponse response = ProductDetailResponse.from(product);
        return ApiResponse.ok(response);
    }

    @Operation(summary = "제품 검색")
    @GetMapping("/search")
    public ApiResponse<ProductSearchResponse> search(
                              @RequestParam String keyword,
                              @RequestParam int page,
                              @RequestParam int size) {

        if (keyword.isBlank()) {
            throw new ProductException(ProductErrorCode.INVALID_KEYWORD);
        }
        ProductSearchResult productSearchResult =
                productService.search(keyword, page, size);

        ProductSearchResponse response =
                ProductSearchResponse.from(productSearchResult);
        return ApiResponse.ok(response);
    }
}
