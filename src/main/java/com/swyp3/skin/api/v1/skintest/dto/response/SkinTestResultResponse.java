package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "피부 진단 결과 응답")
public record SkinTestResultResponse(

        @Schema(description = "진단된 피부 타입", example = "DRY")
        String skinType,

        @Schema(description = "결과 요약 문구", example = "수분 공급과 장벽 케어가 필요한 피부입니다.")
        String summary,

        @ArraySchema(schema = @Schema(implementation = RecommendedIngredientResponse.class))
        List<RecommendedIngredientResponse> ingredients
) {
}