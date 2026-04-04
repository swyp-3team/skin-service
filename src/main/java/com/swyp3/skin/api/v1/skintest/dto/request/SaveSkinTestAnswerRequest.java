package com.swyp3.skin.api.v1.skintest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "설문 답변 저장 요청")
public record SaveSkinTestAnswerRequest(

        @Schema(
                description = "현재 단계에서 사용자가 선택한 선택지 번호",
                example = "3",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "selectedOption은 필수입니다.")
        Integer selectedAnswer
) {
}
