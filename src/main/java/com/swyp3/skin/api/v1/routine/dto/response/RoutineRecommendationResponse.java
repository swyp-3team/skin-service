package com.swyp3.skin.api.v1.routine.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record RoutineRecommendationResponse(
        @Schema(description = "기준 피부 진단 결과 ID", example = "7")
        Long skinResultId,

        @Schema(description = "기준 피부 타입", example = "SENSITIVE")
        String skinType,

        @Schema(description = "루틴 제목", example = "민감 피부 데일리 루틴")
        String title,

        @Schema(description = "루틴 전체 요약", example = "아침에는 진정과 수분 공급, 저녁에는 장벽 회복 중심으로 구성한 루틴입니다")
        String summary,

        @Schema(description = "루틴 사용 시 주의사항", example = "저녁 루틴의 액티브 성분은 주 2~3회부터 시작하세요")
        String caution,

        @Schema(description = "AM 루틴 구성")
        RoutineSectionResponse amRoutine,

        @Schema(description = "PM 루틴 구성")
        RoutineSectionResponse pmRoutine
) {
}
