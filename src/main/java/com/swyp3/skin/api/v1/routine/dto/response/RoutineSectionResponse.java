package com.swyp3.skin.api.v1.routine.dto.response;


import com.swyp3.skin.domain.routine.domain.enums.RoutineType;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "AM 또는 PM 루틴 구성 정보")
public record RoutineSectionResponse(

        @Schema(description = "루틴 ID", example = "31")
        Long routineId,

        @Schema(description = "루틴 타입", example = "AM")
        RoutineType routineType,

        @Schema(description = "루틴 메모", example = "아침에는 자극이 적은 보습 중심으로 사용합니다.")
        String memo,

        @ArraySchema(
                schema = @Schema(implementation = RoutineRecommendedProductResponse.class),
                arraySchema = @Schema(description = "해당 루틴에 포함된 제품 목록")
        )
        List<RoutineRecommendedProductResponse> products
) {
}