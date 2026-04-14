package com.swyp3.skin.domain.skinttest.dto;

import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;

public record SkinPreviewCacheValue(
        Long userId,
        SkinInput skinInput,
        RecommendationResult result,
        String summary
) {
}
