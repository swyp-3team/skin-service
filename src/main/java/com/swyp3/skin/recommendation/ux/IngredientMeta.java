package com.swyp3.skin.recommendation.ux;

import java.util.Map;

public record IngredientMeta(
        String name,
        String description
) {
    public static IngredientMeta get(IngredientType type) {
        return META.get(type);
    }

    private static final Map<IngredientType, IngredientMeta> META = Map.of(
        IngredientType.HYALURONIC_ACID,
        new IngredientMeta("히알루론산", "수분 공급")
    );
}
