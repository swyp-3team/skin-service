package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.Concern;

import java.util.*;

// step 4
public class ConcernWeightApplier {
    private static final double MULTIPLIER = 1.3;

    public Map<IngredientGroup, Double> apply(
            Map<IngredientGroup, Double> scores,
            List<Concern> concerns) {

        // 기존 점수 복사
        Map<IngredientGroup, Double> result = new HashMap<>(scores);

        Map<Concern, IngredientGroup[]> mapping = ConcernMapping.getMapping();

        // 이미 가중치 적용된 성분군 추적 (중복 방지)
        Set<IngredientGroup> boosted = new HashSet<>();

        for (Concern concern : concerns) {

            IngredientGroup[] groups = mapping.get(concern);
            if (groups == null) continue;

            for (IngredientGroup group : groups) {

                // 이미 적용된 경우 skip
                if (boosted.contains(group)) continue;

                // 가중치 적용
                result.computeIfPresent(group,
                        (k, v) -> v * MULTIPLIER);

                // 적용된 그룹 기록
                boosted.add(group);
            }
        }

        return result;
    }
}
