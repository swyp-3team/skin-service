package com.swyp3.skin.api.v1.skintest.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "설문 전체 조회 응답")
public record SkinSurveyResponse(

        @ArraySchema(
                schema = @Schema(implementation = SkinTestStepResponse.class),
                arraySchema = @Schema(description = "설문 전체 문항 목록")
        )
        List<SkinTestStepResponse> questions
) {
}
