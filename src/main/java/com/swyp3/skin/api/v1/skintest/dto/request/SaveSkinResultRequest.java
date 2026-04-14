package com.swyp3.skin.api.v1.skintest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "피부 진단 결과 저장 요청")
public record SaveSkinResultRequest(
        @NotBlank
        @Schema(description = "미리보기 단계에서 발급받은 토큰", example = "3f8e4f3f-54d8-4a21-a20f-0fce8d2cc9a1")
        String previewToken
) {
}
