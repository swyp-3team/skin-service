package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.SkinState;

import java.util.HashMap;
import java.util.Map;

// step 2
public class ScoreCalculator {
    public Map<IngredientGroup, Double> calculate(Map<SkinState, Integer> stateVector) {

        Map<IngredientGroup, Double> result = new HashMap<>();
        Map<SkinState, Map<IngredientGroup, Double>> mapping = ScoreMapping.getMapping();

        for (SkinState state : stateVector.keySet()) {

            int stateScore = stateVector.get(state);

            Map<IngredientGroup, Double> targets = mapping.get(state);
            if (targets == null) continue;

            for (IngredientGroup group : targets.keySet()) {

                double weight = targets.get(group);
                double addScore = stateScore * weight;

                result.put(group, result.getOrDefault(group, 0.0) + addScore);
            }
        }

        return result;
    }
}
