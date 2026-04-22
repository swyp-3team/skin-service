package com.swyp3.skin.api.v1.skintest.mapper;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestResultResponse;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResultGroupScore;
import com.swyp3.skin.domain.skinresult.service.SkinResultGroupScoreService;
import com.swyp3.skin.domain.skinresult.service.SkinResultService;
import com.swyp3.skin.domain.skintest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skintest.exception.SkinTestException;
import com.swyp3.skin.recommendation.ux.IngredientMeta;
import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import com.swyp3.skin.recommendation.ux.SkinUxProfileResolver;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SkinTestResultResponseMapper {

    public static final int PROFILE_NEED_RANKING_SIZE = 2;
    private final SkinResultGroupScoreService skinResultGroupScoreService;
    private final SkinUxProfileResolver skinUxProfileResolver;

    public SkinTestResultResponse toResponse(SkinResult skinResult) {
        List<SkinResultGroupScore> groupScores = skinResultGroupScoreService.getTop2ScoresByResultId(skinResult.getId());
        List<IngredientGroup> ranking = groupScores.stream()
                .map(SkinResultGroupScore::getIngredientGroup)
                .toList();

        validateRankingSize(ranking);
        SkinUxProfile profile = resolveProfile(ranking);

        List<IngredientMeta> ingredientMetas = getIngredientMetas(profile);


        return SkinTestResultResponse.of(today(),profile,ingredientMetas,)
    }

    private static @NonNull List<IngredientMeta> getIngredientMetas(SkinUxProfile profile) {
        return profile.ingredients().stream()
                .map(ingredientType -> {
                    IngredientMeta meta = IngredientMeta.get(ingredientType);
                    if (meta == null) {
                        throw new SkinTestException(SkinTestErrorCode.INGREDIENT_META_NOT_FOUND);
                    }
                    return meta;
                }).toList();
    }

    private static String today() {
        return LocalDate.now(ZoneId.of("Asia/Seoul"))
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    }

    private @NonNull SkinUxProfile resolveProfile(List<IngredientGroup> ranking) {
        return skinUxProfileResolver.resolve(ranking.get(0), ranking.get(1))
                .orElseThrow(() -> new SkinTestException(SkinTestErrorCode.UX_PROFILE_NOT_FOUND));
    }

    private static void validateRankingSize(List<IngredientGroup> ranking) {
        if (ranking.size() < PROFILE_NEED_RANKING_SIZE) {
            throw new SkinTestException(SkinTestErrorCode.INVALID_RECOMMENDATION_RANKING_SIZE);
        }
    }
}
