package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.Concern;

import java.util.*;

// step 4
public class ConcernWeightApplier {
    private static final double MULTIPLIER = 1.5; // 🔥 변경

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

                result.computeIfPresent(group,
                        (k, v) -> v * MULTIPLIER);

                boosted.add(group);
            }
        }

        // 추가 (핵심)
        result.computeIfPresent(IngredientGroup.BARRIER,
                (k, v) -> v * 0.65);

        result.computeIfPresent(IngredientGroup.SOOTHING,
                (k, v) -> v * 0.8);

        return result;
    }
}
