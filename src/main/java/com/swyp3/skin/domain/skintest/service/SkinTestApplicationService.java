package com.swyp3.skin.domain.skintest.service;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestStepMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestion;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestions;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.service.SkinResultGroupScoreService;
import com.swyp3.skin.domain.skinresult.service.SkinResultService;
import com.swyp3.skin.domain.skintest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skintest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skintest.exception.SkinTestException;
import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.repository.UserRepository;
import com.swyp3.skin.global.auth.exception.AuthErrorCode;
import com.swyp3.skin.global.auth.exception.AuthException;
import com.swyp3.skin.recommendation.core.RecommendationEngine;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SkinTestApplicationService {

    private final UserRepository userRepository;

    private final SkinResultService skinResultService;
    private final SkinResultGroupScoreService skinResultGroupScoreService;
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

    @Transactional
    public void saveResult(Long userId, String previewToken) {
        SkinPreviewCacheValue cached = skinPreviewCacheService.get(previewToken);
        if (cached == null) {
            throw new SkinTestException(SkinTestErrorCode.PREVIEW_TOKEN_EXPIRED);
        }
        if (!cached.userId().equals(userId)) {
            throw new SkinTestException(SkinTestErrorCode.INVALID_PREVIEW_TOKEN_OWNER);
        }

        User user = userRepository.findById(userId).orElseThrow(
                () -> new AuthException(AuthErrorCode.USER_NOT_FOUND));
        SkinResult skinResult = skinResultService.save(user,cached);
        skinResultGroupScoreService.saveAll(skinResult,cached.result());

        skinPreviewCacheService.evict(previewToken);
    }
}
