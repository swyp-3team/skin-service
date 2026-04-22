package com.swyp3.skin.recommendation.ux;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

public record SkinUxKey(
        IngredientGroup top1,
        IngredientGroup top2
) {
    public static SkinUxKey of(IngredientGroup top1, IngredientGroup top2) {
        return new SkinUxKey(top1, top2);
    }
}
