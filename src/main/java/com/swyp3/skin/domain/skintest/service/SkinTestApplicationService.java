package com.swyp3.skin.domain.skintest.service;

import com.swyp3.skin.api.v1.skintest.dto.request.AnswerDto;
import com.swyp3.skin.api.v1.skintest.dto.request.CreateSkinResultRequest;
import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
import com.swyp3.skin.api.v1.skintest.dto.response.CreateSkinResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinSurveyResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.api.v1.skintest.mapper.SkinInputMapper;
import com.swyp3.skin.api.v1.skintest.mapper.SkinTestPreviewResponseMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestStepMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestion;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestions;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.service.SkinResultGroupScoreService;
import com.swyp3.skin.domain.skinresult.service.SkinResultService;
import com.swyp3.skin.domain.skintest.dto.ResolvedSkinResultData;
import com.swyp3.skin.domain.skintest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skintest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skintest.exception.SkinTestException;
import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.service.UserService;
import com.swyp3.skin.recommendation.ingredient.core.RecommendationEngine;
import com.swyp3.skin.recommendation.ingredient.model.RecommendationResult;
import com.swyp3.skin.recommendation.ingredient.model.SkinInput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SkinTestApplicationService {

    private final List<SkinTestStepResponse> cachedQuestions = buildCachedQuestions();

    private final UserService userService;

    private final SkinInputMapper skinInputMapper;
    private final SkinTestPreviewResponseMapper previewResponseMapper;

    private final SkinResultService skinResultService;
    private final SkinResultGroupScoreService skinResultGroupScoreService;
    private final SkinPreviewCacheService skinPreviewCacheService;
    private final RecommendationEngine recommendationEngine;

    public RecommendationResult calculate(SkinInput skinInput){
        return recommendationEngine.calculate(skinInput);
    }
    private List<SkinTestStepResponse> buildCachedQuestions() {
        return SkinTestSurveyQuestions.QUESTIONS.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> SkinTestStepMapper.toResponse(entry.getValue()))
                .toList();
    }

    public SkinSurveyResponse getSurveys() {
        return new SkinSurveyResponse(cachedQuestions);
    }

    @Transactional
    public CreateSkinResultResponse createResult(Long userId, CreateSkinResultRequest request) {
        ResolvedSkinResultData resolved = resolveResultData(request);
        Long resultId = persistResult(userId, resolved);

        return new CreateSkinResultResponse(resultId);
    }

    private ResolvedSkinResultData resolveResultData(CreateSkinResultRequest request) {
        if (isPreviewMode(request)){
            SkinPreviewCacheValue cached = skinPreviewCacheService.consume(request.previewToken());
            if (cached == null) {
                throw new SkinTestException(SkinTestErrorCode.PREVIEW_TOKEN_EXPIRED);
            }
            return new ResolvedSkinResultData(
                    cached.skinInput(),
                    cached.result(),
                    cached.typeName(),
                    request.previewToken()
            );
        }

        if (isSurveyMode(request)) {
            SkinTestPreviewRequest previewRequest = toPreviewRequest(request);
            SkinInput skinInput = skinInputMapper.toSkinInput(previewRequest);
            RecommendationResult result = recommendationEngine.calculate(skinInput);
            String typeName = previewResponseMapper.toResponse(result).skinType();

            return new ResolvedSkinResultData(
                    skinInput,
                    result,
                    typeName,
                    null
            );
        }

        throw new SkinTestException(SkinTestErrorCode.INVALID_SURVEY_ANSWER_PAYLOAD);
    }

    private Long persistResult(Long userId, ResolvedSkinResultData resolved) {
        User user = userService.findById(userId);

        SkinPreviewCacheValue savePayload = new SkinPreviewCacheValue(
                resolved.skinInput(),
                resolved.recommendationResult(),
                resolved.typeName()
        );

        SkinResult skinResult = skinResultService.saveFromResolvedData(user, savePayload);
        skinResultGroupScoreService.saveAll(skinResult, resolved.recommendationResult());

        return skinResult.getId();
    }

    private boolean isPreviewMode(CreateSkinResultRequest request) {
        boolean hasToken = request.previewToken() != null && !request.previewToken().isBlank();
        boolean hasSurvey = request.answers() != null || request.skinType() != null || request.concerns() != null;
        return hasToken && !hasSurvey;
    }

    private boolean isSurveyMode(CreateSkinResultRequest request) {
        boolean hasToken = request.previewToken() != null && !request.previewToken().isBlank();
        boolean hasAnswers = request.answers() != null && !request.answers().isEmpty();
        boolean hasSkinType = request.skinType() != null;
        boolean hasConcerns = request.concerns() != null && !request.concerns().isEmpty();
        return !hasToken && hasAnswers && hasSkinType && hasConcerns;
    }

    private SkinTestPreviewRequest toPreviewRequest(CreateSkinResultRequest request) {
        List<AnswerDto> answers = request.answers().stream()
                .map(a -> new AnswerDto(a.step(), a.answer()))
                .toList();

        return new SkinTestPreviewRequest(answers, request.skinType(), request.concerns());
    }
}
