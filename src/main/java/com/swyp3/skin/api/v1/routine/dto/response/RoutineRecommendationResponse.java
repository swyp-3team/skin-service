package com.swyp3.skin.api.v1.routine.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record RoutineRecommendationResponse(
        @Schema(description = "기준 피부 진단 결과 ID", example = "7")
        Long skinResultId,

        @Schema(description = "유형명", example = "촉촉한 수분 결핍형")
        String skinType,

        @Schema(description = "피부 타입 설명", example = "속은 건조한데 겉은 번들거려요.")
        String subtitle,

        @Schema(description = "루틴 설명", example =  "수분이 부족해지면 피부 장벽도 함께 약해져요. 보습제를 발라도 금방 건조해지는 이유가 바로 이 악순환 때문이에요. 수분을 채우면서 장벽을 복구하는 이중 케어가 필요해요.")
        String routineSummary,

        @Schema(description = "AM 루틴 구성")
        RoutineSectionResponse amRoutine,

        @Schema(description = "PM 루틴 구성")
        RoutineSectionResponse pmRoutine
) {
}
