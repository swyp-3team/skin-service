package com.swyp3.skin.api.v1.routine.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "루틴 그룹 목록 조회 응답")
public record RoutineListResponse(

        @ArraySchema(
                schema = @Schema(implementation = RoutineSummaryResponse.class),
                arraySchema = @Schema(description = "조회된 루틴 그룹 목록")
        )
        List<RoutineSummaryResponse> routines,

        @Schema(description = "현재 페이지 번호", example = "0")
        Integer page,

        @Schema(description = "페이지 크기", example = "10")
        Integer size,

        @Schema(description = "전체 데이터 개수", example = "12")
        Long totalElements,

        @Schema(description = "전체 페이지 수", example = "2")
        Integer totalPages
) {
}