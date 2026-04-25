package com.swyp3.skin.domain.routine.service;

import com.swyp3.skin.api.v1.routine.dto.response.*;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.routine.domain.enums.RoutineStepCategory;
import com.swyp3.skin.domain.routine.domain.enums.RoutineType;
import com.swyp3.skin.domain.routine.exception.RoutineErrorCode;
import com.swyp3.skin.domain.routine.exception.RoutineException;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResultGroupScore;
import com.swyp3.skin.domain.skinresult.repository.SkinResultGroupScoreRepository;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import com.swyp3.skin.recommendation.ux.SkinUxKey;
import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.swyp3.skin.recommendation.ux.SkinUxProfileRegistry.PROFILES;

@Service
@RequiredArgsConstructor
public class RoutineRecommendationService {

    private final RoutineCompositionService routineCompositionService;
    private final SkinResultGroupScoreRepository skinResultGroupScoreRepository;

    public RoutineRecommendationResponse recommend(
        List<RecommendedProduct> recommendedProducts,
        SkinResult skinResult) {
        Map<RoutineType, Map<RoutineStepCategory, List<RecommendedProduct>>> productsByStepCategory =
                routineCompositionService.compose(recommendedProducts);
        return toRecommendationResponse(productsByStepCategory, skinResult);
    }

    private RoutineRecommendationResponse toRecommendationResponse(
            Map<RoutineType, Map<RoutineStepCategory, List<RecommendedProduct>>> productsByStepCategory,
            SkinResult skinResult
    ) {
        RoutineSectionResponse amRoutine = null;
        RoutineSectionResponse pmRoutine = null;
        SkinUxProfile uxProfile = resolveSkinUxProfile(skinResult);

        for (Map.Entry<RoutineType, Map<RoutineStepCategory, List<RecommendedProduct>>> routineTypeEntry : productsByStepCategory.entrySet()) {
            List<RoutineRecommendedProductResponse> routineProducts = new ArrayList<>();
            for (Map.Entry<RoutineStepCategory, List<RecommendedProduct>> stepCategoryEntry : routineTypeEntry.getValue().entrySet()) {
                routineProducts.add(toProductResponse(stepCategoryEntry.getValue().get(0), stepCategoryEntry.getKey()));
            }
            RoutineSectionResponse sectionResponse = new RoutineSectionResponse(
                    routineTypeEntry.getKey(),
                    routineProducts
            );
            switch (routineTypeEntry.getKey()) {
                case AM -> amRoutine = sectionResponse;
                case PM -> pmRoutine = sectionResponse;
            }
        }
        if(amRoutine == null || pmRoutine == null) {
            throw new RoutineException(RoutineErrorCode.ROUTINE_COMPOSITION_FAILED);
        }

        return new RoutineRecommendationResponse(
                skinResult.getId(),
                uxProfile.skinType(),
                uxProfile.subtitle(),
                uxProfile.routineSummary(),
                amRoutine,
                pmRoutine
        );
    }

    private RoutineRecommendedProductResponse toProductResponse(
            RecommendedProduct recommendedProduct,
            RoutineStepCategory routineStepCategory
    ) {
        Product product = recommendedProduct.getProduct();
        return new RoutineRecommendedProductResponse(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getImageUrl(),
                routineStepCategory
        );
    }

    private SkinUxProfile resolveSkinUxProfile(SkinResult skinResult) {
        List<SkinResultGroupScore> topGroupScores =
                skinResultGroupScoreRepository.findTop2BySkinResultIdOrderByPriorityAsc(skinResult.getId());

        if (topGroupScores.size() < 2) {
            throw new RoutineException(RoutineErrorCode.ROUTINE_UX_PROFILE_NOT_FOUND);
        }

        IngredientGroup top1 = topGroupScores.get(0).getIngredientGroup();
        IngredientGroup top2 = topGroupScores.get(1).getIngredientGroup();
        if (top1 == null || top2 == null) {
            throw new RoutineException(RoutineErrorCode.ROUTINE_UX_PROFILE_NOT_FOUND);
        }

        for (Map.Entry<SkinUxKey, SkinUxProfile> profileEntry : PROFILES.entrySet()) {
            SkinUxKey uxKey = profileEntry.getKey();
            if (uxKey.top1() == top1 && uxKey.top2() == top2) {
                return profileEntry.getValue();
            }
        }

        throw new RoutineException(RoutineErrorCode.ROUTINE_UX_PROFILE_NOT_FOUND);
    }


}
