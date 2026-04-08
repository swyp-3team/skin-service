package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// step 6 정렬
public class RankingCalculator {

    public List<IngredientGroup> rank(Map<IngredientGroup, Double> scores) {

        return scores.entrySet()
                .stream()

                // value 기준 내림차순 정렬
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))

                // key(성분군)만 추출
                .map(Map.Entry::getKey)

                // 리스트로 변환
                .collect(Collectors.toList());
    }
}
