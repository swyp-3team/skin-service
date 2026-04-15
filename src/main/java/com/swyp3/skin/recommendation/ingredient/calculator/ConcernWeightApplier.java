package com.swyp3.skin.recommendation.ingredient.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.enums.Concern;

import java.util.*;

// step 4
public class ConcernWeightApplier {
    // 성분군별 차등 부스트 배율
    private static final Map<IngredientGroup, Double> BOOST_MAP = Map.of(
            IngredientGroup.BARRIER,       1.4,
            IngredientGroup.SOOTHING,      1.3,
            IngredientGroup.TURNOVER,      1.2,
            IngredientGroup.HYDRATION,     1.4,
            IngredientGroup.SEBUM_CONTROL, 1.4,
            IngredientGroup.ACNE,          1.4,
            IngredientGroup.BRIGHTENING,   1.3,
            IngredientGroup.ANTI_AGING,    1.3
    );

    public Map<IngredientGroup, Double> apply(
            Map<IngredientGroup, Double> scores,
            List<Concern> concerns) {

        Map<IngredientGroup, Double> result = new HashMap<>(scores);
        Map<Concern, IngredientGroup[]> mapping = ConcernMapping.getMapping();
        Set<IngredientGroup> boosted = new HashSet<>();

        for (Concern concern : concerns) {
            IngredientGroup[] groups = mapping.get(concern);
            if (groups == null) continue;

            for (IngredientGroup group : groups) {
                if (boosted.contains(group)) continue;

                double multiplier = BOOST_MAP.getOrDefault(group, 1.5);
                result.computeIfPresent(group, (k, v) -> v * multiplier);
                boosted.add(group);
            }
        }

        // 페널티 없음 — MAX 재계산으로 대체

        return result;
    }
}
