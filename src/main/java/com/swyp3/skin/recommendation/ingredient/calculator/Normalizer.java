package com.swyp3.skin.recommendation.ingredient.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.HashMap;
import java.util.Map;

// step 3
// 이론적 각 상태군 최대 점수값이 달라 정확한 상대비교가 불가능
// 그래서 각 점수 정규화를 통해 상대비교 용이하게 변경
public class Normalizer {
    public Map<IngredientGroup, Double> normalize(Map<IngredientGroup, Double> rawScores) {

        Map<IngredientGroup, Double> normalized = new HashMap<>();

        for (IngredientGroup group : rawScores.keySet()) {

            double raw = rawScores.get(group);

            // 해당 성분군의 최대값
            double max = NormalizationConstants.MAX_SCORES.get(group);

            // 정규화: raw / max
            double value = raw / max;

            normalized.put(group, value);
        }

        return normalized;
    }
}
