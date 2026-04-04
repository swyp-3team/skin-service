package com.swyp3.skin.api.v1.product.dto.response;


import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "제품 목록 조회 응답")
public record ProductListResponse(

        @ArraySchema(
                schema = @Schema(implementation = ProductSummaryResponse.class),
                arraySchema = @Schema(description = "조회된 제품 목록")
        )
        List<ProductSummaryResponse> products,

        @Schema(description = "현재 페이지 번호", example = "0")
        Integer page,

        @Schema(description = "페이지 크기", example = "10")
        Integer size,

        @Schema(description = "전체 데이터 개수", example = "25")
        Long totalElements,

        @Schema(description = "전체 페이지 수", example = "3")
        Integer totalPages
) {
}
