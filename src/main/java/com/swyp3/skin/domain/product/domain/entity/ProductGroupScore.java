package com.swyp3.skin.domain.product.domain.entity;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class ProductGroupScore extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private IngredientGroup ingredientGroup;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Integer priority;
}