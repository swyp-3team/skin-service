package com.swyp3.skin.api.v1.skintest.dto.request;

import com.swyp3.skin.domain.skinresult.domain.enums.Concern;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.util.List;

@Schema(description = "피부 진단 결과 생성 요청")
public record CreateSkinResultRequest(

        @Schema(description = "미리보기 단계에서 발급받은 토큰",example = "3f8e4f3f-54d8-4a21-a20f-0fce8d2cc9a1")
        String previewToken,

        @Valid
        @Schema(description = "문항별 답변 목록")
        List<AnswerDto> answers,


        @Valid
        @Schema(
                description = "사용자 피부 타입 (설문 모드)",
                example = "OILY",
                allowableValues = {"DRY", "OILY", "SENSITIVE", "COMBINATION", "UNKNOWN"}
        )
        SkinType skinType,

        @Schema(
                description = "사용자 피부 고민 목록 (설문 모드)",
                example = "[\"ACNE\",\"SEBUM\"]"
        )
        List<Concern> concerns
) {
}
