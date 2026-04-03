package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "내 최신 진단 결과 응답")
public record MySkinTestResultResponse(

        @Schema(description = "진단 결과 ID", example = "10")
        Long skinResultId,

        @Schema(description = "피부 타입", example = "SENSITIVE")
        String skinType,

        @Schema(description = "결과 요약 문구", example = "진정 케어 중심의 관리가 적합합니다.")
        String summary,

        @Schema(description = "진단 시각", example = "2026-04-03T14:30:00")
        LocalDateTime diagnosedAt
) {
}
