package com.swyp3.skin.domain.skinttest.service;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestStepMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestion;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestions;
import com.swyp3.skin.domain.skinttest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skinttest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skinttest.exception.SkinTestException;
import com.swyp3.skin.domain.user.domain.repository.UserRepository;
import com.swyp3.skin.recommendation.core.RecommendationEngine;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkinTestApplicationService {

    private final UserRepository userRepository;
    private final SkinPreviewCacheService skinPreviewCacheService;
    private final RecommendationEngine recommendationEngine;

    public RecommendationResult calculate(SkinInput skinInput){
        return recommendationEngine.calculate(skinInput);
    }

    public SkinTestStepResponse getSurveyStep(int step) {
        SkinTestSurveyQuestion question = SkinTestSurveyQuestions.QUESTIONS.get(step);

        if (question == null) {
            throw new SkinTestException(SkinTestErrorCode.INVALID_SURVEY_STEP);
        }

        return SkinTestStepMapper.toResponse(question);
    }

    public void saveResult(Long userId, String previewToken) {
        SkinPreviewCacheValue cached = skinPreviewCacheService.get(previewToken);
        if (cached == null) {
            throw new SkinTestException(SkinTestErrorCode.PREVIEW_TOKEN_EXPIRED);
        }
        if (!cached.userId().equals(userId)) {
            throw new SkinTestException(SkinTestErrorCode.INVALID_PREVIEW_TOKEN_OWNER);
        }

        userRepository.findById(userId).orElseThrow(
                () -> new );
    }
}
