package com.swyp3.skin.api.v1.product.controller;

import com.swyp3.skin.api.v1.product.dto.response.ProductDetailResponse;
import com.swyp3.skin.api.v1.product.dto.response.ProductListResponse;
import com.swyp3.skin.domain.product.service.ProductGroupScoreService;
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

@Tag(name = "Product", description = "제품추천")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final SkinResultService skinResultService;
    private final ProductRecommendationService productRecommendationService;
    private final ProductGroupScoreService productGroupScoreService;

    @Operation(summary = "추천 제품 조회")
    @GetMapping("/recommend")
    public ApiResponse<ProductListResponse> recommend(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @RequestParam(required = false) String category
            ) {
        Long userId = userDetails.getUserId();

        List<RecommendedProduct> recommended = productRecommendationService.recommend(
                skinResultService.getLatestByUserId(userId)
                        .getId()
        );

        // 카테고리 필터링
        if(category != null) {
            recommended = recommended.stream()
                    .filter(p ->
                            p.getProduct().getCategory().name().equalsIgnoreCase(category))
                            .toList();
        }

        List<RecommendedProduct> top = recommended.stream()
                .limit(10)
                .toList();

        // 프로덕트 그룹 스코어 가져오기 위해서 -> 추후 태그로 활용
        List<Long> productIds = top.stream()
                .map(recommendedProduct -> recommendedProduct.getProduct().getId())
                .toList();



        ProductListResponse.from(top);

        return null;
    }

    @Operation(
            summary = "제품 상세 조회",
            description = "특정 제품의 상세 정보와 포함 성분 정보를 조회합니다."
    )
    @GetMapping("/{productId}")
    public ApiResponse<ProductDetailResponse> getDetail(@PathVariable Long productId) {
        // TODO: 제품 상세 조회
        return null;
    }

    @Operation(summary = "제품 검색")
    @GetMapping("/search")
    public ApiResponse<ProductListResponse> search(
                              @RequestParam String keyword,
                              @RequestParam int page,
                              @RequestParam int size) {
        // TODO: 검색 로직
        return null;
    }
}
