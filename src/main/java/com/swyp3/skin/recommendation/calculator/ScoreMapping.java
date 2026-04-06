package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.SkinState;

import java.util.HashMap;
import java.util.Map;

// step 1
public class ScoreMapping {
    public static Map<SkinState, Map<IngredientGroup, Double>> getMapping() {

        Map<SkinState, Map<IngredientGroup, Double>> mapping = new HashMap<>();

        // Dryness
        Map<IngredientGroup, Double> dryness = new HashMap<>();
        dryness.put(IngredientGroup.HYDRATION, 1.0);
        dryness.put(IngredientGroup.SOOTHING, 0.3);
        mapping.put(SkinState.DRYNESS, dryness);

        // Sebum
        Map<IngredientGroup, Double> sebum = new HashMap<>();
        sebum.put(IngredientGroup.ACNE, 1.0);
        mapping.put(SkinState.SEBUM, sebum);

        // Acne
        Map<IngredientGroup, Double> acne = new HashMap<>();
        acne.put(IngredientGroup.ACNE, 1.0);
        acne.put(IngredientGroup.SOOTHING, 0.3);
        mapping.put(SkinState.ACNE, acne);

        // Sensitivity
        Map<IngredientGroup, Double> sensitivity = new HashMap<>();
        sensitivity.put(IngredientGroup.SOOTHING, 1.0);
        sensitivity.put(IngredientGroup.HYDRATION, 0.3);
        mapping.put(SkinState.SENSITIVITY, sensitivity);

        // Pigmentation
        Map<IngredientGroup, Double> pigmentation = new HashMap<>();
        pigmentation.put(IngredientGroup.PIGMENTATION, 1.0);
        pigmentation.put(IngredientGroup.TURNOVER, 0.3);
        mapping.put(SkinState.PIGMENTATION, pigmentation);

        return mapping;
    }
}
