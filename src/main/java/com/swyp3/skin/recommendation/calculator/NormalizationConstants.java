package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;

import java.util.Map;

public class NormalizationConstants {

    public static final Map<IngredientGroup, Double> MAX_SCORES = Map.of(

            IngredientGroup.HYDRATION, 110.5,
            IngredientGroup.BARRIER, 120.0,

            IngredientGroup.ACNE, 170.0,
            IngredientGroup.SEBUM_CONTROL, 130.0,

            IngredientGroup.SOOTHING, 136.0,

            IngredientGroup.BRIGHTENING, 110.0,
            IngredientGroup.TURNOVER, 60.0,

            IngredientGroup.ANTI_AGING, 100.0
    );
}
