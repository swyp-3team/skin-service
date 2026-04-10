package com.swyp3.skin.api.v1.skintest.mapper;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestPreviewResponse;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkinTestPreviewResponseMapper {

    // 기존 ranking은 IngredientGroup 리스트만 갖고있지만 각 그룹 TopIngredientDto 으로 변환
    public SkinTestPreviewResponse toResponse(SkinType skinType, RecommendationResult result) {
        List<SkinTestPreviewResponse.TopIngredientDto> top3 = result.getRanking().stream()
                .limit(3)
                .map(group -> new SkinTestPreviewResponse.TopIngredientDto(
                        group,
                        result.getRanking().indexOf(group) + 1,
                        representativeIngredients(group),
                        reason(group)
                ))
                .toList();

        String summary = top3.isEmpty()
                ? "추천 가능한 성분군이 없습니다." // 예외처리로 변경하는것도 가능
                : top3.stream()
                .map(t -> t.group().name())
                .reduce((a, b) -> a + ", " + b)
                .map(s -> "현재 피부 상태 기준 추천 성분군은 " + s + " 입니다.")
                .orElse("현재 피부 상태 기준 추천 성분군을 도출했습니다.");

        return new SkinTestPreviewResponse(skinType, summary, top3);
    }

    private List<String> representativeIngredients(IngredientGroup group) {
        return switch (group) {
            case ACNE -> List.of("살리실산", "아젤라익산");
            case SEBUM_CONTROL -> List.of("나이아신아마이드", "징크 PCA");
            case SOOTHING -> List.of("판테놀", "센텔라");
            case HYDRATION -> List.of("히알루론산", "글리세린");
            case BARRIER -> List.of("세라마이드", "콜레스테롤");
            case BRIGHTENING -> List.of("비타민C", "트라넥사믹애씨드");
            case TURNOVER -> List.of("PHA", "락틱애씨드");
            case ANTI_AGING -> List.of("레티놀", "펩타이드");
        };
    }

    private String reason(IngredientGroup group) {
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
