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

        @Schema(description = "다음 데이터 존재 여부", example = "true")
        boolean hasNext,

        @Schema(description = "다음 조회에 사용할 커서", example = "21")
        Long nextCursor
) {
        public static RoutineListResponse from(
                List<RoutineSummaryResponse> routines,
                boolean hasNext
        ) {
                Long nextCursor = (hasNext && !routines.isEmpty())
                        ? routines.get(routines.size() - 1).routineGroupId()
                        : null;

                return new RoutineListResponse(routines, hasNext, nextCursor);
        }
}