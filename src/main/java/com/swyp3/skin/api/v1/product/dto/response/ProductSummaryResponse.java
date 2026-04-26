package com.swyp3.skin.api.v1.product.dto.response;

import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "제품 목록 카드 정보")
public record ProductSummaryResponse(

        @Schema(description = "제품 ID", example = "1")
        Long productId,

        @Schema(description = "제품명", example = "수분 토너")
        String name,

        @Schema(description = "가격 (원)", example = "21000")
        int price,

        @Schema(description = "제품 이미지 URL", example = "https://cdn.example.com/product.png")
        String imageUrl
) {

    public static ProductSummaryResponse from(RecommendedProduct recommendedProduct) {
        Product product = recommendedProduct.getProduct();
        return new ProductSummaryResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl()
        );
    }

    public static ProductSummaryResponse from(Product product) {
        return new ProductSummaryResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl()
        );
    }
}
