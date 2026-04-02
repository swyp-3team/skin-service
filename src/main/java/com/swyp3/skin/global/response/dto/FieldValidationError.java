package com.swyp3.skin.global.response.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "필드 단위 검증 실패 정보")
public record FieldValidationError(

        @Schema(description = "검증 실패 필드명", example = "nickname")
        String filed,

        @Schema(description = "잘못 들어온 값 ", example = "")
        Object rejectedValue,

        @Schema(description = "검증 실패 사유", example = "닉네임은 필수입니다")
        String reason
        ) {
    public static FieldValidationError of(String filed, Object rejectedValue, String reason) {
        return new FieldValidationError(filed, rejectedValue, reason);
    }
}
