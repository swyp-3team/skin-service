package com.swyp3.skin.recommendation.calculator;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.enums.Concern;

import java.util.HashMap;
import java.util.Map;

// 고민 -> 성분군 매핑
public class ConcernMapping {

    public static Map<Concern, IngredientGroup[]> getMapping() {

        Map<Concern, IngredientGroup[]> mapping = new HashMap<>();

        // 건조
        mapping.put(Concern.DRY, new IngredientGroup[]{
                IngredientGroup.HYDRATION,   // 수분 공급
                IngredientGroup.BARRIER      // 장벽 강화
        });

        // 트러블
        mapping.put(Concern.ACNE, new IngredientGroup[]{
                IngredientGroup.ACNE,        // 여드름 케어
                IngredientGroup.SOOTHING     // 진정
        });

        // 색소
        mapping.put(Concern.PIGMENTATION, new IngredientGroup[]{
                IngredientGroup.BRIGHTENING, // 미백 / 톤 개선
                IngredientGroup.TURNOVER     // 각질 / 재생
        });

        // 노화
        mapping.put(Concern.AGING, new IngredientGroup[]{
                IngredientGroup.ANTI_AGING,  // 주름 / 탄력
                IngredientGroup.TURNOVER     // 재생 보조
        });

        // 민감
        mapping.put(Concern.SENSITIVE, new IngredientGroup[]{
                IngredientGroup.SOOTHING,    // 진정
                IngredientGroup.BARRIER      // 장벽 강화
        });

        // 피지
        mapping.put(Concern.SEBUM, new IngredientGroup[]{
                IngredientGroup.SEBUM_CONTROL // 피지 조절 (핵심 수정)
        });

        // 모공
        mapping.put(Concern.PORE, new IngredientGroup[]{
                IngredientGroup.SEBUM_CONTROL, // 피지 조절 (핵심)
//                IngredientGroup.TURNOVER       // 각질/재생 (모공 정리 핵심)
        });

        return mapping;
    }
}
