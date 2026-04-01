package com.swyp3.skin.domain.skintest.domain.entity;

import com.swyp3.skin.domain.ingredient.domain.entity.Ingredient;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkinResultIngredient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private SkinResult skinResult;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private Ingredient ingredient;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private String reason;
}
