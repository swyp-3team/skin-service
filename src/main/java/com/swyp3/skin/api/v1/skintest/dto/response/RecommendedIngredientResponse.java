package com.swyp3.skin.api.v1.skintest.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "추천 성분 정보")
public record RecommendedIngredientResponse(
        // Ingredient 에서 id,name,type 받아오고
        // SkinResultIngredient 에서 priority,reason
        @Schema(description = "성분 ID", example = "1")
        Long ingredientId,

        @Schema(description = "성분명", example = "히알루론산")
        String name,

        @Schema(description = "성분 타입", example = "MOISTURIZING")
        String ingredientType,

        @Schema(description = "추천 우선순위", example = "1")
        Integer priority,

        @Schema(description = "추천 이유", example = "건조한 피부에 수분 보충에 도움을 줄 수 있습니다.")
        String reason
) {
}
