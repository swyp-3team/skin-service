package com.swyp3.skin.api.v1.skintest.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "설문 문항 답변")
public record AnswerDto(

        @NotNull
        @Min(1)
        @Schema(description = "설문 단계 번호", example = "1")
        Integer step,

        @NotNull
        @Min(1) @Max(5)
        @Schema(description = "선택한 답변 값 (1~5)", example = "5")
        Integer answer
) {}