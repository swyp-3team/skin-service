package com.swyp3.skin.recommendation.ux;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "사용자 UX 프로필")
public record SkinUxProfile(
        @Schema(description = "유형명", example = "촉촉한 수분 결핍형")
        String typeName,

        @Schema(description = "타입 설명", example = "속은 건조한데 겉은 번들거려요")
        String subtitle,

        @Schema(description = "피부설명")
        String summary,

        @Schema(description = "루틴 설명")
        String subSummary,

        @Schema(description = "루틴 원형 내용물")
        List<String> concerns,

        @Schema(description = "필요 성분 모음")
        List<IngredientType> ingredients
) {}
