package com.swyp3.skin.api.v1.product.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ProductSearchResponse(

        @ArraySchema(
                schema = @Schema(implementation = ProductSummaryResponse.class),
                arraySchema = @Schema(description = "추천 제품 목록")
        )
        List<ProductSummaryResponse> products,

        @Schema(description = "다음 페이지 존재 여부", example = "true")
        boolean hasNext
) {
    public static ProductSearchResponse from(ProductSearchResult result) {

        List<ProductSummaryResponse> products = result.products().stream()
                .map(product -> new ProductSummaryResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getImageUrl()
                ))
                .toList();

        return new ProductSearchResponse(
                products,
                result.hasNext()
        );
    }
}
