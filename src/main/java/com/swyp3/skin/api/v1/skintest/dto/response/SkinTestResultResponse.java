package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

// 해당 파일은 로직결정및 응답구조 결정됨에 따라 유기적 변경 예정
@Schema(description = "피부 진단 결과 응답")
public record SkinTestResultResponse(

        @Schema(description = "사용자가 선택한 피부 타입", example = "SENSITIVE")
        String skinType,

        @Schema(description = "결과 요약 문구", example = "진정과 트러블 케어를 우선으로 두는 루틴이 적합합니다.")
        String summary,

        @ArraySchema(
                schema = @Schema(implementation = RecommendedIngredientResponse.class),
                arraySchema = @Schema(description = "상위 성분군 기준 추천 성분 목록")
        )
        List<RecommendedIngredientResponse> ingredients
) {
}