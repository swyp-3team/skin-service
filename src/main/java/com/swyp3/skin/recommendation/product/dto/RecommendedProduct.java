package com.swyp3.skin.recommendation.product.dto;

import com.swyp3.skin.domain.product.domain.entity.Product;
import lombok.Getter;

@Getter
public class RecommendedProduct {

    private final Product product;
    private final double score;

    public RecommendedProduct(Product product, double score) {
        this.product = product;
        this.score = score;
    }
}
