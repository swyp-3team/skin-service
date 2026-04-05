package com.swyp3.skin.api.v1.routine.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "루틴 그룹 목록에서 사용하는 요약 정보")
public record RoutineSummaryResponse(

        @Schema(description = "루틴 그룹 ID", example = "21")
        Long routineGroupId,

        @Schema(description = "루틴 제목", example = "민감 피부 데일리 루틴")
        String title,

        @Schema(description = "기준 피부 타입", example = "SENSITIVE")
        String skinType,

        @Schema(description = "루틴 전체 요약", example = "아침 진정, 저녁 장벽 회복 중심")
        String summary,

        @Schema(description = "AM 루틴 ID", example = "31")
        Long amRoutineId,

        @Schema(description = "PM 루틴 ID", example = "32")
        Long pmRoutineId,

        @Schema(description = "생성 시각", example = "2026-04-05T14:30:00")
        LocalDateTime createdAt
) {
}