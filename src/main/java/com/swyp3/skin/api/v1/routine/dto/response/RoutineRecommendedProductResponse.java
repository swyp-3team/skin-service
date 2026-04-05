package com.swyp3.skin.api.v1.routine.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "루틴 추천/상세에서 사용하는 제품 정보")
public record RoutineRecommendedProductResponse(

        @Schema(description = "제품 ID", example = "12")
        Long productId,

        @Schema(description = "제품명", example = "시카 진정 토너")
        String name,

        @Schema(description = "브랜드명", example = "SKINLAB")
        String brand,

        @Schema(description = "제품 카테고리", example = "TONER")
        String category,

        @Schema(description = "제품 대표 이미지 URL", example = "https://cdn.example.com/products/12.png")
        String imageUrl,

        @Schema(description = "루틴 내 사용 순서", example = "1")
        Integer sortOrder,

        @Schema(description = "추천 이유", example = "민감한 피부를 진정시키는 성분이 포함되어 첫 단계에 적합합니다.")
        String reason,

        @Schema(description = "사용 포인트", example = "손바닥에 덜어 가볍게 눌러 흡수시켜 주세요.")
        String note
) {
}
