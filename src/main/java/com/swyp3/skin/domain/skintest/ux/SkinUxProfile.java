package com.swyp3.skin.api.v1.skintest.ux;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "스킨테스트 UX 프로필")
public record SkinUxProfile(
        @Schema(description = "유형명", example = "촉촉한 수분 결핍형")
        String typeName,

        @Schema(description = "부제", example = "속은 건조한데 겉은 번들거려요")
        String subtitle,

        @Schema(description = "추천 성분 태그")
        List<String> recommendedTags,

        @Schema(description = "한 줄 이유 문구")
        String oneLineReason,

        @Schema(description = "피해야 할 성분")
        List<String> avoidIngredients,

        @Schema(description = "참고용 데이터 여부", example = "false")
        boolean referenceOnly
) {}
