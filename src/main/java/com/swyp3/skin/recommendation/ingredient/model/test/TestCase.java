package com.swyp3.skin.recommendation.ingredient.model.test;

import com.swyp3.skin.recommendation.ingredient.model.enums.Concern;
import com.swyp3.skin.recommendation.ingredient.model.enums.SkinState;
import com.swyp3.skin.recommendation.ingredient.model.enums.SkinType;

import java.util.List;
import java.util.Map;

public class TestCase {

    public Map<SkinState, Integer> stateVector;
    public List<Concern> concerns;
    public SkinType skinType;

    public TestCase(Map<SkinState, Integer> stateVector,
                    List<Concern> concerns,
                    SkinType skinType) {
        this.stateVector = stateVector;
        this.concerns = concerns;
        this.skinType = skinType;
    }
}
