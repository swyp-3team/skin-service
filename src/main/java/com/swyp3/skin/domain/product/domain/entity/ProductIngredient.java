package com.swyp3.skin.domain.product.domain.entity;

import com.swyp3.skin.domain.ingredient.domain.entity.Ingredient;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class ProductIngredient extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private Ingredient ingredient;

    private Boolean mainIngredient;
    private Integer displayOrder;
}