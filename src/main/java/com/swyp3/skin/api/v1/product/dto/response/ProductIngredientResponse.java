package com.swyp3.skin.api.v1.product.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "제품에 포함된 성분 정보")
public record ProductIngredientResponse(

        @Schema(description = "성분 ID", example = "1")
        Long ingredientId,

        @Schema(description = "성분명", example = "히알루론산")
        String name,

        @Schema(description = "성분 타입", example = "MOISTURIZING")
        String ingredientType
) {
}
