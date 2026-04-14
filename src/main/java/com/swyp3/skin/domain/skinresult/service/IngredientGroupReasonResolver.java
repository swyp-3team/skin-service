package com.swyp3.skin.domain.skinresult.service;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import org.springframework.stereotype.Component;

@Component
public class IngredientGroupReasonResolver {
    public String resolve(IngredientGroup group) {
        return switch (group) {
            case ACNE -> "트러블 완화와 염증 관리가 필요합니다.";
            case SEBUM_CONTROL -> "과도한 피지 분비 조절이 필요합니다.";
            case SOOTHING -> "피부 자극 완화와 진정 케어가 필요합니다.";
            case HYDRATION -> "수분 보충과 건조 개선이 필요합니다.";
            case BARRIER -> "피부 장벽 회복과 보호가 필요합니다.";
            case BRIGHTENING -> "칙칙함 개선과 톤 케어가 필요합니다.";
            case TURNOVER -> "각질 턴오버 개선이 필요합니다.";
            case ANTI_AGING -> "탄력 및 주름 개선 케어가 필요합니다.";
        };
    }
}
