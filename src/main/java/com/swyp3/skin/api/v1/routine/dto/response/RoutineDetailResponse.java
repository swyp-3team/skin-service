package com.swyp3.skin.api.v1.routine.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "루틴 그룹 상세 조회 응답")
public record RoutineDetailResponse(

        @Schema(description = "루틴 그룹 ID", example = "21")
        Long routineGroupId,

        @Schema(description = "루틴 제목", example = "민감 피부 데일리 루틴")
        String title,

        @Schema(description = "기준 피부 진단 결과 ID", example = "7")
        Long skinResultId,

        @Schema(description = "기준 피부 타입", example = "SENSITIVE")
        String skinType,

        @Schema(description = "루틴 전체 요약", example = "민감도가 높아 진정과 장벽 회복 중심으로 구성한 루틴입니다.")
        String summary,

        @Schema(description = "주의사항", example = "아침 루틴 마지막 단계에서 자외선 차단제를 꼭 사용하세요.")
        String caution,

        @Schema(description = "AM 루틴 구성")
        RoutineSectionResponse amRoutine,

        @Schema(description = "PM 루틴 구성")
        RoutineSectionResponse pmRoutine,

        @Schema(description = "생성 시각", example = "2026-04-05T14:30:00")
        LocalDateTime createdAt
) {
}
