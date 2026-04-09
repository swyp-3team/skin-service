package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.Map;

public class NormalizationConstants {

    public static final Map<IngredientGroup, Double> MAX_SCORES = Map.of(

            IngredientGroup.HYDRATION,     85.0,
            IngredientGroup.BARRIER,       102.0,
            IngredientGroup.ACNE,          161.5,
            IngredientGroup.SEBUM_CONTROL, 102.0,
            IngredientGroup.SOOTHING,      131.75,
            IngredientGroup.BRIGHTENING,   130.0,
            IngredientGroup.TURNOVER,      89.25,
            IngredientGroup.ANTI_AGING,    119.0
    );
}
