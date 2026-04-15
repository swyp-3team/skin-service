package com.swyp3.skin.recommendation.product.dto;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import lombok.Getter;

import java.util.Map;

@Getter
public class ProductSupply {

    private final Long productId;
    private final Map<IngredientGroup, Double> supply;

    public ProductSupply(Long productId, Map<IngredientGroup, Double> supply) {
        this.productId = productId;
        this.supply = supply;
    }
}
