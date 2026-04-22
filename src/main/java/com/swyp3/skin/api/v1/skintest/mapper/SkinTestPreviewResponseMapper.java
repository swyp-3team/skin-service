package com.swyp3.skin.api.v1.skintest.mapper;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestPreviewResponse;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.enums.SkinType;
import com.swyp3.skin.domain.skintest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skintest.exception.SkinTestException;
import com.swyp3.skin.recommendation.ingredient.model.RecommendationResult;
import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import com.swyp3.skin.recommendation.ux.SkinUxProfileResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SkinTestPreviewResponseMapper {


    public static final int PROFILE_NEED_RANKING_SIZE = 2;
    private final SkinUxProfileResolver skinUxProfileResolver;

    public SkinTestPreviewResponse toResponse(RecommendationResult result) {

        List<IngredientGroup> ranking = result.getRanking();
        String diagnosedDate = LocalDate.now(ZoneId.of("Asia/Seoul"))
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        if (ranking.size() < PROFILE_NEED_RANKING_SIZE) {
            throw new SkinTestException(SkinTestErrorCode.INVALID_RECOMMENDATION_RANKING_SIZE);
        }

        SkinUxProfile profile = skinUxProfileResolver.resolve(ranking.get(0), ranking.get(1))
                .orElseThrow(() -> new SkinTestException(SkinTestErrorCode.UX_PROFILE_NOT_FOUND));

        return SkinTestPreviewResponse.of(diagnosedDate,profile);
    }

}
