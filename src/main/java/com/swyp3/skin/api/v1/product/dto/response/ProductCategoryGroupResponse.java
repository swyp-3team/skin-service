package com.swyp3.skin.api.v1.product.dto.response;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "카테고리별 제품 그룹")
public record ProductCategoryGroupResponse(

        @Schema(description = "카테고리", example = "TONER")
        String category,

        @ArraySchema(
                schema = @Schema(implementation = ProductSummaryResponse.class),
                arraySchema = @Schema(description = "제품 목록")
        )
        List<ProductSummaryResponse> products
) {
}