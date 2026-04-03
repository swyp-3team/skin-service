package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "설문 단계 조회 응답")
public record SkinTestStepResponse(

        @Schema(
                description = "현재 조회한 설문 단계 번호",
                example = "2"
        )
        Integer step,

        @Schema(
                description = "현재 단계의 질문 문구",
                example = "오후가 되면 얼굴에 유분이 많이 올라오나요?"
        )
        String question,

        @ArraySchema(
                schema = @Schema(implementation = SkinTestQuestionOptionResponse.class),
                arraySchema = @Schema(description = "현재 단계에서 선택 가능한 선택지 목록")
        )
        List<SkinTestQuestionOptionResponse> options,

        @Schema(
                description = "해당 단계에서 사용자가 기존에 선택했던 선택지 번호. 아직 응답하지 않았으면 null입니다.",
                example = "3",
                nullable = true
        )
        Integer selectedAnswer
) {
}