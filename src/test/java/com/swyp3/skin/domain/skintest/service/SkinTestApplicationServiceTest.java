package com.swyp3.skin.domain.skintest.service;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.domain.enums.Concern;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import com.swyp3.skin.domain.skinresult.service.SkinResultGroupScoreService;
import com.swyp3.skin.domain.skinresult.service.SkinResultService;
import com.swyp3.skin.domain.skintest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skintest.exception.SkinTestException;
import com.swyp3.skin.domain.user.domain.entity.User;
import com.swyp3.skin.domain.user.repository.UserRepository;
import com.swyp3.skin.recommendation.core.RecommendationEngine;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import com.swyp3.skin.recommendation.model.enums.SkinState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SkinTestApplicationServiceTest {
    @Mock UserRepository userRepository;
    @Mock SkinResultService skinResultService;
    @Mock SkinResultGroupScoreService skinResultGroupScoreService;
    @Mock SkinPreviewCacheService skinPreviewCacheService;
    @Mock RecommendationEngine recommendationEngine;

    @InjectMocks SkinTestApplicationService skinTestApplicationService;


    @Test
    void getSurveyStep_정상() {
        SkinTestStepResponse response = skinTestApplicationService.getSurveyStep(1);
        assertThat(response.step()).isEqualTo(1);
        assertThat(response.question()).isNotBlank();
        assertThat(response.options()).isNotEmpty();
    }

    @Test
    void getSurveyStep_스텝오류(){
        assertThrows(SkinTestException.class, () -> skinTestApplicationService.getSurveyStep(999));
    }

    @Test
    void saveResult_정상흐름() {
        Long userId = 1L;
        String token = "preview-token";

        SkinInput input = new SkinInput(
                Map.of(SkinState.DRYNESS, 55),
                List.of(Concern.ACNE),
                SkinType.OILY
        );
        RecommendationResult result = new RecommendationResult(
                Map.of(IngredientGroup.ACNE, 1.2),
                List.of(IngredientGroup.ACNE)
        );
        SkinPreviewCacheValue cached = new SkinPreviewCacheValue(userId, input, result, "요약");
        User user = mock(User.class);
        SkinResult skinResult = mock(SkinResult.class);

        // 토큰으로 캐시 조회하면 preview결과
        when(skinPreviewCacheService.get(token)).thenReturn(cached);
        // 사용자 조회
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        // DB저장 결과 -> mock
        when(skinResultService.save(user, cached)).thenReturn(skinResult);

        skinTestApplicationService.saveResult(userId, token);

        // 실제로 DB저장 되었는지
        verify(skinResultService).save(user, cached);
        // 성분군 점수 저장
        verify(skinResultGroupScoreService).saveAll(skinResult, result);
        // 캐시 제거
        verify(skinPreviewCacheService).evict(token);
    }

    @Test
    void saveResult_토큰없음_예외() {
        when(skinPreviewCacheService.get("bad-token")).thenReturn(null);

        assertThrows(SkinTestException.class,
                () -> skinTestApplicationService.saveResult(1L, "bad-token"));
    }
}