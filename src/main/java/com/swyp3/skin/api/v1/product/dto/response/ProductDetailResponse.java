package com.swyp3.skin.api.v1.product.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "제품 상세 조회 응답")
public record ProductDetailResponse(

        @Schema(description = "제품 ID", example = "1")
        Long productId,

        @Schema(description = "제품명", example = "수분 진정 세럼")
        String name,

        @Schema(description = "브랜드명", example = "SKINLAB")
        String brand,

        @Schema(description = "제품 카테고리", example = "SERUM")
        String category,

        @Schema(description = "제품 설명", example = "민감하고 건조한 피부를 위한 진정 보습 세럼입니다.")
        String description,

        @Schema(description = "제품 대표 이미지 URL", example = "https://cdn.example.com/product-1.png")
        String imageUrl,

        @Schema(description = "구매 링크", example = "https://shop.example.com/product/1")
        String purchaseUrl,

        @ArraySchema(
                schema = @Schema(implementation = ProductGroupScoreResponse.class),
                arraySchema = @Schema(description = "제품 성분군 점수 목록")
        )
        List<ProductGroupScoreResponse> groupScores
) {
}
