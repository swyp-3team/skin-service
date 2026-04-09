package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.enums.SkinState;

import java.util.HashMap;
import java.util.Map;

// step 1
public class ScoreMapping {
    // v1
//    public static Map<SkinState, Map<IngredientGroup, Double>> getMapping() {
//
//        Map<SkinState, Map<IngredientGroup, Double>> mapping = new HashMap<>();
//
//        // Dryness
//        Map<IngredientGroup, Double> dryness = new HashMap<>();
//        dryness.put(IngredientGroup.HYDRATION, 1.0);
//        dryness.put(IngredientGroup.SOOTHING, 0.3);
//        mapping.put(SkinState.DRYNESS, dryness);
//
//        // Sebum
//        Map<IngredientGroup, Double> sebum = new HashMap<>();
//        sebum.put(IngredientGroup.ACNE, 1.0);
//        mapping.put(SkinState.SEBUM, sebum);
//
//        // Acne
//        Map<IngredientGroup, Double> acne = new HashMap<>();
//        acne.put(IngredientGroup.ACNE, 1.0);
//        acne.put(IngredientGroup.SOOTHING, 0.3);
//        mapping.put(SkinState.ACNE, acne);
//
//        // Sensitivity
//        Map<IngredientGroup, Double> sensitivity = new HashMap<>();
//        sensitivity.put(IngredientGroup.SOOTHING, 1.0);
//        sensitivity.put(IngredientGroup.HYDRATION, 0.3);
//        mapping.put(SkinState.SENSITIVITY, sensitivity);
//
//        // Pigmentation
//        Map<IngredientGroup, Double> pigmentation = new HashMap<>();
//        pigmentation.put(IngredientGroup.PIGMENTATION, 1.0);
//        pigmentation.put(IngredientGroup.TURNOVER, 0.3);
//        mapping.put(SkinState.PIGMENTATION, pigmentation);
//
//        return mapping;
//    }

    public static Map<SkinState, Map<IngredientGroup, Double>> getMapping() {

        Map<SkinState, Map<IngredientGroup, Double>> mapping = new HashMap<>();

        // DRYNESS (건조)
        Map<IngredientGroup, Double> dryness = new HashMap<>();
        dryness.put(IngredientGroup.HYDRATION, 1.0);
        dryness.put(IngredientGroup.BARRIER,   1.0);     // 장벽 강화 (핵심)
        mapping.put(SkinState.DRYNESS, dryness);

        // SEBUM (피지)
        Map<IngredientGroup, Double> sebum = new HashMap<>();
        sebum.put(IngredientGroup.SEBUM_CONTROL, 1.2); // 피지 조절 (핵심)
        sebum.put(IngredientGroup.ACNE, 0.4);          // 트러블 예방 (약하게)
        mapping.put(SkinState.SEBUM, sebum);

        // ACNE (트러블)
        Map<IngredientGroup, Double> acne = new HashMap<>();
        acne.put(IngredientGroup.ACNE,    1.3);
        acne.put(IngredientGroup.SOOTHING, 0.3);      // 진정
        mapping.put(SkinState.ACNE, acne);

        // SENSITIVITY (민감)
        Map<IngredientGroup, Double> sensitivity = new HashMap<>();
        sensitivity.put(IngredientGroup.SOOTHING, 1.25);
        sensitivity.put(IngredientGroup.BARRIER,  0.8);  // 장벽 강화
        mapping.put(SkinState.SENSITIVITY, sensitivity);

        // PIGMENTATION (색소)
        Map<IngredientGroup, Double> pigmentation = new HashMap<>();
        pigmentation.put(IngredientGroup.BRIGHTENING, 1.25); // 미백/톤 개선 (핵심)
        pigmentation.put(IngredientGroup.TURNOVER, 0.5);    // 각질/재생 보조
        mapping.put(SkinState.PIGMENTATION, pigmentation);

        // AGING (노화)
        Map<IngredientGroup, Double> aging = new HashMap<>();
        aging.put(IngredientGroup.ANTI_AGING, 1.4);  // 핵심 (탄력/주름 개선)
        aging.put(IngredientGroup.TURNOVER, 0.35);    // 보조 (재생)
        mapping.put(SkinState.AGING, aging);

        return mapping;
    }
}
