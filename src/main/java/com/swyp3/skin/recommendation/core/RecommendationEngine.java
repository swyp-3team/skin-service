package com.swyp3.skin.recommendation.core;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.calculator.ScoreCalculator;
import com.swyp3.skin.recommendation.model.SkinInput;

import java.util.Map;

public class RecommendationEngine {

    public RecommendationEngine calculate(SkinInput input) {
        /*
         * 1. 상태 벡터 사용
         * 2. 성분군 원점수 계산
         * 3. 정규화
         * 4. 고민 가중치 적용
         * 5. 피부 타입 보정
         * 6. 정렬 및 랭킹
         */

        ScoreCalculator calculator = new ScoreCalculator();
        Map<IngredientGroup, Double> rawScores = calculator.calculate(input.getStateVector());


        return null;
    }
}
