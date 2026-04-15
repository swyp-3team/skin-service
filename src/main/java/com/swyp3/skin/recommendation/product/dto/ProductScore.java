package com.swyp3.skin.recommendation.product.dto;

public class ProductScore {

    private final Long productId;
    private final double score;

    public ProductScore(Long productId, double score) {
        this.productId = productId;
        this.score = score;
    }

    public Long getProductId() {
        return productId;
    }

    public double getScore() {
        return score;
    }
}