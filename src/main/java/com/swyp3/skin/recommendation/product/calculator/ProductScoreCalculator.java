package com.swyp3.skin.recommendation.product.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductScoreCalculator {

    public List<ProductScore> calculate(
            Map<IngredientGroup, Double> need,
            List<ProductSupply> supplies
    ) {
        List<ProductScore> result = new ArrayList<>();

        for (ProductSupply supply : supplies) {
            double score = dotProduct(need, supply.getSupply());

            result.add(new ProductScore(
                    supply.getProductId(),
                    score
            ));
        }

        return result;
    }

    private double dotProduct(
            Map<IngredientGroup, Double> need,
            Map<IngredientGroup, Double> supply
    ) {
        double sum = 0.0;

        for (IngredientGroup group : need.keySet()) {
            double n = need.getOrDefault(group, 0.0);
            double s = supply.getOrDefault(group, 0.0);

            sum += n * s;
        }

        return sum;
    }
}