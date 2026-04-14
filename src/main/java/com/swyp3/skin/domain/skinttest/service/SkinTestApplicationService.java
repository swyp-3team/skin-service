package com.swyp3.skin.domain.skinttest.service;

import com.swyp3.skin.recommendation.core.RecommendationEngine;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkinTestApplicationService {
    private final RecommendationEngine recommendationEngine;

    public RecommendationResult calculate(SkinInput skinInput){
        return recommendationEngine.calculate(skinInput);
    }

}
