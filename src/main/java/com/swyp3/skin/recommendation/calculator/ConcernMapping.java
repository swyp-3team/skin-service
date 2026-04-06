package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.Concern;

import java.util.HashMap;
import java.util.Map;

// 고민 -> 성분군 매핑
public class ConcernMapping {
    public static Map<Concern, IngredientGroup[]> getMapping() {

        Map<Concern, IngredientGroup[]> mapping = new HashMap<>();

        mapping.put(Concern.DRY, new IngredientGroup[]{
                IngredientGroup.HYDRATION, IngredientGroup.SOOTHING
        });

        mapping.put(Concern.ACNE, new IngredientGroup[]{
                IngredientGroup.ACNE, IngredientGroup.SOOTHING
        });

        mapping.put(Concern.PIGMENTATION, new IngredientGroup[]{
                IngredientGroup.PIGMENTATION, IngredientGroup.TURNOVER
        });

        mapping.put(Concern.AGING, new IngredientGroup[]{
                IngredientGroup.TURNOVER, IngredientGroup.PIGMENTATION
        });

        mapping.put(Concern.SENSITIVE, new IngredientGroup[]{
                IngredientGroup.SOOTHING, IngredientGroup.HYDRATION
        });

        mapping.put(Concern.SEBUM, new IngredientGroup[]{
                IngredientGroup.ACNE
        });

        return mapping;
    }
}
