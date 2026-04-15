package com.swyp3.skin.api.v1.product.dto.response;

import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.product.domain.entity.ProductGroupScore;
import com.swyp3.skin.recommendation.product.dto.RecommendedProduct;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Schema(description = "제품 목록에서 사용하는 요약 정보")
public record ProductSummaryResponse(

        @Schema(description = "제품 ID", example = "1")
        Long productId,

        @Schema(description = "제품명", example = "수분 토너")
        String name,

        @Schema(description = "브랜드명", example = "라네즈")
        String brand,

        @Schema(description = "이미지 URL")
        String imageUrl,

        @Schema(description = "업데이트 기준 정보", example = "3일 전 업데이트")
        String updatedInfo,

        @Schema(description = "태그", example = "[\"HYDRATION\",\"SOOTHING\"]")
        List<String> tags
) {

    public static ProductSummaryResponse from(
            RecommendedProduct recommendedProduct,
            Map<Long,List<ProductGroupScore>> groupScoreMap){
        Product product = recommendedProduct.getProduct();

        List<ProductGroupScore> scores =
                groupScoreMap.getOrDefault(product.getId(), List.of());

        List<String> tags = scores.stream()
                .sorted(Comparator.comparingInt(ProductGroupScore::getPriority))
                .limit(2)
                .map(s -> s.getIngredientGroup().name())
                .toList();

        return new ProductSummaryResponse(
                product.getId(),
                product.getName(),
                product.getBrand(),
                product.getImageUrl(),
                toUpdatedInfo(product.getUpdatedAt()),
                tags
        );
    }

    private static String toUpdatedInfo(LocalDateTime updatedAt) {
        return updatedAt.getMonthValue() + "월 " + updatedAt.getDayOfMonth() + "일";
    }
}
