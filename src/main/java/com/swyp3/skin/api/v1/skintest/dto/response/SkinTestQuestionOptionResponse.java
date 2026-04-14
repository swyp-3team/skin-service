package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "설문 선택지 정보")
public record SkinTestQuestionOptionResponse(

        @Schema(
                description = "선택지 번호 프론트는 이 값을 기준으로 선택 상태를 관리",
                example = "1"
        )
        Integer optionNumber,

        @Schema(
                description = "사용자 화면에 노출할 선택지 문구",
                example = "매우 건조해요"
        )
        String content,
        @Schema(
                description = "선택지 코드값(14: 피부고민, 15: 피부타입). 1~13 단계는 null",
                example = "ACNE",
                nullable = true
        )
        String code
) {
}