package com.swyp3.skin.recommendation.core;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.calculator.*;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import com.swyp3.skin.recommendation.model.enums.SkinState;

import java.util.List;
import java.util.Map;

public class RecommendationEngine {

    private final ScoreCalculator scoreCalculator = new ScoreCalculator();
    private final Normalizer normalizer = new Normalizer();
    private final ConcernWeightApplier concernWeightApplier = new ConcernWeightApplier();
    private final SkinTypeAdjuster skinTypeAdjuster = new SkinTypeAdjuster();
    private final RankingCalculator rankingCalculator = new RankingCalculator();

    public RecommendationResult calculate(SkinInput input) {

        // Step2 상태 → 성분군 원점수
        Map<IngredientGroup, Double> rawScores =
                scoreCalculator.calculate(input.getStateVector());

        // step3 정규화
        Map<IngredientGroup, Double> normalized =
                normalizer.normalize(rawScores);

        // step4 고민 가중치 적용
        Map<IngredientGroup, Double> weighted =
                concernWeightApplier.apply(normalized, input.getConcerns());

        // BARRIER 보정을 위한
        double dryness = input.getStateVector().getOrDefault(SkinState.DRYNESS, 0);
        double sensitivity = input.getStateVector().getOrDefault(SkinState.SENSITIVITY, 0);

        if (dryness < 60 && sensitivity < 60) {
            weighted.computeIfPresent(IngredientGroup.BARRIER,
                    (k, v) -> v * 0.7);
        }

        // step5 피부타입 보정
        Map<IngredientGroup, Double> adjusted =
                skinTypeAdjuster.adjust(weighted, input.getSkinType());

        // step6 정렬
        List<IngredientGroup> ranking = rankingCalculator.rank(adjusted);

        return new RecommendationResult(adjusted, ranking);
    }
}
