package com.swyp3.skin.api.v1.routine.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "루틴 저장 완료 응답")
public record SaveRoutineResponse(

        @Schema(description = "저장된 루틴 그룹 ID", example = "21")
        Long routineGroupId,

        @Schema(description = "저장된 루틴 제목", example = "민감 피부 데일리 루틴")
        String title,

        @Schema(description = "저장 완료 메시지", example = "추천 루틴이 저장되었습니다.")
        String message
) {
}
