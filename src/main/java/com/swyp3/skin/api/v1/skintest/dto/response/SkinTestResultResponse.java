package com.swyp3.skin.api.v1.skintest.dto.response;

import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
import com.swyp3.skin.recommendation.ux.IngredientMeta;
import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "내 최신 진단 결과 응답")
public record SkinTestResultResponse(

        @Schema(description = "진단 시각", example = "2026.04.22")
        String diagnosedAt,

        @Schema(description = "타입 네임")
        String typeName,

        @Schema(description = "타입 설명")
        String subTitle,

        @Schema(description = "피부 설명")
        String summary,

        @Schema(description = "피부 고민(원형안에 삽입)")
        List<String> concerns,

        @Schema(description = "피부 고민 설명")
        String subSummary,

        @Schema(description = "추천 성분및 섦명")
        List<IngredientMeta> ingredientMetas
) {
        public static SkinTestResultResponse of(
                String diagnosedAt,
                SkinUxProfile uxProfile,
                List<IngredientMeta> ingredientMetas
        ){
                return new SkinTestResultResponse(
                        diagnosedAt,
                        uxProfile.typeName(),
                        uxProfile.subtitle(),
                        uxProfile.summary(),
                        uxProfile.concerns(),
                        uxProfile.subSummary(),
                        ingredientMetas
                );
        }
}
