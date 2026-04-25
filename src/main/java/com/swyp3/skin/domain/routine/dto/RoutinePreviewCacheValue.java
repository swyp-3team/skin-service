package com.swyp3.skin.domain.routine.dto;

import com.swyp3.skin.api.v1.routine.dto.response.RoutineRecommendationResponse;

public record RoutinePreviewCacheValue(
        Long userId,
        RoutineRecommendationResponse response
) {
}
