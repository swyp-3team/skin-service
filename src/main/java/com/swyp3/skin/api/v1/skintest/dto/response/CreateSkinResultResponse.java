package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "피부 진단 결과 생성 응답")
public record CreateSkinResultResponse(
        @Schema(description = "저장된 피부 진단 결과 ID", example = "12")
        Long resultId
) {
}
