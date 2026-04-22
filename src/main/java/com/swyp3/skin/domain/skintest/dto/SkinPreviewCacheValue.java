package com.swyp3.skin.domain.skintest.dto;

import com.swyp3.skin.recommendation.ingredient.model.RecommendationResult;
import com.swyp3.skin.recommendation.ingredient.model.SkinInput;

public record SkinPreviewCacheValue(
        SkinInput skinInput,
        RecommendationResult result,
        String typeName
) {
}
