package com.swyp3.skin.api.v1.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "제품 목록에서 사용하는 요약 정보")
public record ProductSummaryResponse(

        @Schema(description = "제품 ID", example = "1")
        Long productId,

        @Schema(description = "제품명", example = "수분 진정 세럼")
        String name,

        @Schema(description = "브랜드명", example = "SKINLAB")
        String brand,

        @Schema(description = "제품 카테고리", example = "SERUM")
        String category,

        @Schema(description = "제품 대표 이미지 URL", example = "https://cdn.example.com/product-1.png")
        String imageUrl
) {
}
