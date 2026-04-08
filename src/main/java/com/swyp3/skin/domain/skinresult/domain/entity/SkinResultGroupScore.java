package com.swyp3.skin.domain.skinresult.domain.entity;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkinResultGroupScore extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private SkinResult skinResult;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private IngredientGroup ingredientGroup;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Integer priority;

    @Column(nullable = false)
    private String reason;
}
