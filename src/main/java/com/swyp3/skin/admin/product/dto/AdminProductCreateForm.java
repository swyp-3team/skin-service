package com.swyp3.skin.admin.product.dto;

import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AdminProductCreateForm(

        @NotBlank(message = "상품명은 필수입니다.")
        String name,

        @NotBlank(message = "브랜드는 필수입니다.")
        String brand,

        @NotNull(message = "카테고리는 필수입니다.")
        ProductCategory category,

        @NotBlank(message = "설명은 필수입니다.")
        @Size(max = 1000, message = "설명은 1000자 이하로 입력해주세요.")
        String description,

        @NotBlank(message = "이미지 URL은 필수입니다.")
        String imageUrl,

        @NotBlank(message = "구매 URL은 필수입니다.")
        String purchaseUrl,

        @NotNull(message = "활성 여부는 필수입니다.")
        Boolean active
) {
}

