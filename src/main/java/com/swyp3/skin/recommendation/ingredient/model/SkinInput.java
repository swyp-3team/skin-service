package com.swyp3.skin.recommendation.ingredient.model;

import com.swyp3.skin.domain.skinresult.domain.enums.Concern;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import com.swyp3.skin.recommendation.ingredient.model.enums.SkinState;

import java.util.List;
import java.util.Map;

public class SkinInput {
    // 피부 상태 점수 백터 : SEBUM - 55
    private Map<SkinState, Integer> stateVector;
    // 사용자가 선택한 피부 고민 (복수선택 가능 -> List)
    private List<Concern> concerns;
    // 사용자가 선택한 피부 타입
    private SkinType skinType;

    public SkinInput(Map<SkinState, Integer> stateVector,
                     List<Concern> concerns,
                     SkinType skinType) {
        this.stateVector = stateVector;
        this.concerns = concerns;
        this.skinType = skinType;
    }

    public Map<SkinState, Integer> getStateVector() {
        return stateVector;
    }

    public List<Concern> getConcerns() {
        return concerns;
    }

    public SkinType getSkinType() {
        return skinType;
    }
}
