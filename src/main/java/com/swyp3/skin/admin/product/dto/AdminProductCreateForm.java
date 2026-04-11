package com.swyp3.skin.admin.product.dto;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record AdminProductCreateForm(
        @NotBlank(message = "상품명은 필수입니다.")
        String name,

        @NotBlank(message = "브랜드는 필수입니다.")
        String brand,

        @NotNull(message = "카테고리는 필수입니다.")
        ProductCategory category,

        @NotNull(message = "가격은 필수입니다.")
        @DecimalMin(value = "0", inclusive = true, message = "가격은 0 이상이어야 합니다.")
        Integer price,

        @NotBlank(message = "설명은 필수입니다.")
        @Size(max = 1000, message = "설명은 1000자 이하로 입력해주세요.")
        String description,

        @NotBlank(message = "이미지 URL은 필수입니다.")
        String imageUrl,

        @NotBlank(message = "구매 URL은 필수입니다.")
        String purchaseUrl,

        @NotNull(message = "활성 여부는 필수입니다.")
        Boolean active,

        @Valid
        @Size(min = 3, max = 3, message = "성분군 점수는 Top3만 입력해야 합니다.")
        List<GroupScoreForm> groupScores
) {
    public static AdminProductCreateForm empty() {
        return new AdminProductCreateForm(
                "", "", null, 0, "", "", "", true,
                List.of(
                        new GroupScoreForm(null, null),
                        new GroupScoreForm(null, null),
                        new GroupScoreForm(null, null)
                )
        );
    }

    public record GroupScoreForm(
            @NotNull(message = "성분군은 필수입니다.")
            IngredientGroup ingredientGroup,

            @NotNull(message = "점수는 필수입니다.")
            @DecimalMin(value = "0.0", inclusive = true, message = "점수는 0 이상이어야 합니다.")
            Double score
    ) {}
}

