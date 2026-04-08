package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.SkinType;

import java.util.HashMap;
import java.util.Map;

public class SkinTypeAdjuster {
    public Map<IngredientGroup, Double> adjust(
            Map<IngredientGroup, Double> scores,
            SkinType skinType) {

        // 원본 보존을 위해 복사
        Map<IngredientGroup, Double> result = new HashMap<>(scores);

        if (skinType == null) return result;

        switch (skinType) {

            case DRY:
                // 건성: 보습/진정 강화
                multiply(result, IngredientGroup.HYDRATION, 1.2);
                multiply(result, IngredientGroup.SOOTHING, 1.1);
                break;

            case OILY:
                // 지성: 피지/트러블 중심
                multiply(result, IngredientGroup.HYDRATION, 0.8);
                multiply(result, IngredientGroup.ACNE, 1.1);
                break;

            case SENSITIVE:
                // 민감성: 진정 강화 + 자극 요소 약화
                multiply(result, IngredientGroup.SOOTHING, 1.2);
                multiply(result, IngredientGroup.TURNOVER, 0.8);
                multiply(result, IngredientGroup.ACNE, 0.9);
                break;

            case COMBINATION:
                // 복합성: 보정 없음
                break;
        }

        return result;
    }

    // null체크용
    private void multiply(Map<IngredientGroup, Double> map,
                          IngredientGroup group,
                          double multiplier) {

        map.computeIfPresent(group, (k, v) -> v * multiplier);
    }
}
