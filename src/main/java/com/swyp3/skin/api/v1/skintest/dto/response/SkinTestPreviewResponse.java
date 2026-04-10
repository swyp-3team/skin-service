
package com.swyp3.skin.api.v1.skintest.dto.response;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "피부 진단 미리보기 응답")
public record SkinTestPreviewResponse(

        @Schema(description = "선택한 피부 타입", example = "OILY")
        SkinType skinType,

        @Schema(description = "결과 요약 문장", example = "피지와 트러블 관리가 우선이며 진정 케어가 필요합니다.")
        String summary,

        @Schema(description = "우선순위 상위 3개 추천 성분군")
        List<TopIngredientDto> top3
) {
    @Schema(description = "추천 성분군 정보")
    public record TopIngredientDto(

            @Schema(description = "성분군", example = "SOOTHING")
            IngredientGroup group,

            @Schema(description = "우선순위 (1이 가장 높음)", example = "1")
            Integer priority,

            @Schema(description = "대표 성분 목록", example = "[\"판테놀\",\"센텔라\"]")
            List<String> ingredients,

            @Schema(description = "추천 이유", example = "피부 진정 및 염증 완화 필요")
            String reason
    ) {}
}