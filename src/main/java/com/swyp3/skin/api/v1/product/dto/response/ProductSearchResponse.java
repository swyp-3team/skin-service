package com.swyp3.skin.api.v1.product.dto.response;

import com.swyp3.skin.domain.common.pagination.SliceResult;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record ProductSearchResponse(
        @ArraySchema(
                schema = @Schema(implementation = ProductSummaryResponse.class),
                arraySchema = @Schema(description = "검색 제품 목록")
        )
        List<ProductSummaryResponse> products,

        @Schema(description = "다음 페이지 존재 여부", example = "true")
        boolean hasNext,

        @Schema(description = "마지막 상품의 ID", example = "12")
        Long nextCursor
)
{
    public static ProductSearchResponse from(
            SliceResult<ProductSummaryResponse> searched,
            boolean hasNext
    ) {

        List<ProductSummaryResponse> products = searched.items();

        Long nextCursor = (hasNext && !products.isEmpty())
                ? products.get(products.size() - 1).productId()
                : null;

        return new ProductSearchResponse(
                products,
                hasNext,
                nextCursor
        );
    }
}

