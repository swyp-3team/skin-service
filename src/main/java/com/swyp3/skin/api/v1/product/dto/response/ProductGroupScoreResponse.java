package com.swyp3.skin.api.v1.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "제품에 포함된 성분 정보")
public record ProductGroupScoreResponse(

        @Schema(description = "성분군", example = "HYDRATION")
        String ingredientGroup,

        @Schema(description = "정규화 점수", example = "0.82")
        Double score,

        @Schema(description = "그룹 내 순위", example = "1")
        Integer rank
) {
}
