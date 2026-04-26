package com.swyp3.skin.domain.product.service;

import com.swyp3.skin.api.v1.product.dto.response.ProductListResponse;
import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.common.pagination.CursorPaginationUtils;
import com.swyp3.skin.domain.common.pagination.SliceResult;
import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.domain.skinresult.domain.entity.SkinResultGroupScore;
import com.swyp3.skin.domain.skinresult.service.SkinResultGroupScoreService;
import com.swyp3.skin.domain.skinresult.service.SkinResultService;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import com.swyp3.skin.recommendation.product.service.ProductRecommendationService;
import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductRecommendationFacade {

    private final ProductService productService;
    private final SkinResultService skinResultService;
    private final SkinResultGroupScoreService skinResultGroupScoreService;
    private final ProductRecommendCacheService productRecommendCacheService;


    public ProductListResponse getRecommendedProducts(
            Long userId,
            Long skinResultId,
            List<String> categories,
            Long cursor,
            int size) {

        SkinResult skinResult = (skinResultId != null)
                ? skinResultService.getSkinResultById(skinResultId,userId)
                : skinResultService.getLatestByUserId(userId);

        List<RecommendedProduct> recommended =
                productRecommendCacheService.getOrCalculate(skinResult.getId());


        List<RecommendedProduct> filtered =
                productService.filter(recommended, categories);

        SliceResult<RecommendedProduct> sliced =
                CursorPaginationUtils.sliceWithCursor(
                        filtered,
                        cursor,
                        size,
                        recommendedProduct ->
                                recommendedProduct.getProduct().getId());

        List<SkinResultGroupScore> groupScores = skinResultGroupScoreService.getTop2ScoresByResultId(skinResult.getId());
        List<IngredientGroup> ranking = groupScores.stream()
                .map(SkinResultGroupScore::getIngredientGroup)
                .toList();

        validateRankingSize(ranking);
        SkinUxProfile profile = resolveProfile(ranking);

        return ProductListResponse.from(
                sliced.items(),
                skinResult,
                sliced.hasNext()
        );
    }
}
