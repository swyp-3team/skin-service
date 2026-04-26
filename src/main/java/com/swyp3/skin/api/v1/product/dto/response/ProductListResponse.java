package com.swyp3.skin.api.v1.product.dto.response;


import com.swyp3.skin.domain.skinresult.domain.entity.SkinResult;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "추천 제품 조회 응답")
public record ProductListResponse(

        @Schema(description = "유형명", example = "촉촉한 수분 결핍형")
        String skinType,

        @Schema(description = "부제", example = "속은 건조한데 겉은 번들거려요")
        String subtitle,

        @Schema(description = "피부 설명")
        String summary,

        @Schema(
                description = "피부 진단 결과 기준 날짜 (YYYY-MM-DD)",
                example = "2026-04-16"
        )
        String skinResultDate,

        @ArraySchema(
                schema = @Schema(implementation = ProductSummaryResponse.class),
                arraySchema = @Schema(description = "추천 제품 목록")
        )
        List<ProductSummaryResponse> products,

        @Schema(description = "다음 페이지 존재 여부", example = "true")
        boolean hasNext,

        @Schema(description = "마지막 상품의 ID", example = "12")
        Long nextCursor
        ) {

    public static ProductListResponse from(
            SkinUxProfile profile,
            List<RecommendedProduct> sliced,
            SkinResult skinResult,
            boolean hasNext
    ) {
        String skinType = profile.skinType();
        String subtitle = profile.subtitle();
        String summary = profile.summary();


        List<String> tags = skinResult.getConcerns().stream()
                .map(Enum::name)
                .toList();

        String skinResultDate = skinResult.getCreatedAt()
                .toLocalDate()
                .toString();

        List<ProductSummaryResponse> products = sliced.stream()
                .map(ProductSummaryResponse::from)
                .toList();

        Long nextCursor = (hasNext && !sliced.isEmpty())
                ? sliced.get(sliced.size() - 1).getProduct().getId()
                : null;

        return new ProductListResponse(
                skinType,
                subtitle,
                summary,
                skinResultDate,
                products,
                hasNext,
                nextCursor
        );
    }
}
