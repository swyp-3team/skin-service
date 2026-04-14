package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "피부 진단 미리보기 응답")
public record SkinTestPreviewWithTokenResponse(
        @Schema(description = "미리보기 결과", requiredMode = Schema.RequiredMode.REQUIRED)
        SkinTestPreviewResponse preview,

        @Schema(description = "저장 시 사용하는 미리보기 토큰", example = "3f8e4f3f-54d8-4a21-a20f-0fce8d2cc9a1")
        String previewToken
) {
}
