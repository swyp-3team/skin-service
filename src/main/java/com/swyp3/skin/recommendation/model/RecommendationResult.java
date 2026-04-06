package com.swyp3.skin.recommendation.model;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;

import java.util.List;
import java.util.Map;

public class RecommendationResult {

    // 성분군 최종 점수 ( ACNE - 1.18)
    private Map<IngredientGroup, Double> scores;

    // 점수 기반 정렬된 성분군 순위
    private List<IngredientGroup> ranking;

    public RecommendationResult(Map<IngredientGroup, Double> scores, List<IngredientGroup> ranking) {
        this.scores = scores;
        this.ranking = ranking;
    }
    public Map<IngredientGroup, Double> getScores() {
        return scores;
    }

    public List<IngredientGroup> getRanking() {
        return ranking;
    }

}
