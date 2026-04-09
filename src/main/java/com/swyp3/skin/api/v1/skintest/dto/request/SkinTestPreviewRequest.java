package com.swyp3.skin.api.v1.skintest.dto.request;

import com.swyp3.skin.recommendation.model.enums.Concern;
import com.swyp3.skin.recommendation.model.enums.SkinType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Schema(description = "피부 진단 미리보기 요청")
public record SkinTestPreviewRequest(

        @NotEmpty
        @Valid
        @Schema(
                description = "문항별 답변 목록",
                example = "[{\"step\":1,\"answer\":5},{\"step\":2,\"answer\":3}]"
        )
        List<AnswerDto> answers,

        @NotNull
        @Schema(
                description = "사용자 피부 타입",
                example = "OILY",
                allowableValues = {"DRY", "OILY", "SENSITIVE", "COMBINATION", "UNKNOWN"}
        )
        SkinType skinType,

        @NotEmpty
        @Schema(
                description = "사용자 피부 고민 목록",
                example = "[\"ACNE\",\"SEBUM\"]"
        )
        List<Concern> concerns
) {
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
}
