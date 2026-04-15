package com.swyp3.skin.api.v1.product.dto.response;


import com.swyp3.skin.domain.product.domain.entity.ProductGroupScore;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Schema(description = "추천 제품 조회 응답")
public record ProductListResponse(

        @ArraySchema(
                schema = @Schema(implementation = ProductCategoryGroupResponse.class),
                arraySchema = @Schema(description = "카테고리별 제품 목록")
        )
        List<ProductCategoryGroupResponse> categories
) {

    public static ProductListResponse from(
            List<RecommendedProduct> recommended,
            Map<Long, List<ProductGroupScore>> groupScoreMap
    ) {

        Map<String, List<RecommendedProduct>> grouped = recommended.stream()
                .collect(Collectors.groupingBy(
                        p -> p.getProduct().getCategory().name()
                ));

        List<ProductCategoryGroupResponse> categories = grouped.entrySet().stream()
                .map(entry -> {

                    List<ProductSummaryResponse> products = entry.getValue().stream()
                            .map(rp -> ProductSummaryResponse.from(rp, groupScoreMap))
                            .toList();

                    return new ProductCategoryGroupResponse(
                            entry.getKey(),
                            products
                    );
                })
                .toList();

        return new ProductListResponse(categories);
    }
}
