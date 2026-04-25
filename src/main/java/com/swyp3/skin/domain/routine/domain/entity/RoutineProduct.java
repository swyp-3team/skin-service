package com.swyp3.skin.domain.routine.domain.entity;

import com.swyp3.skin.domain.product.domain.entity.Product;
import com.swyp3.skin.domain.routine.domain.enums.RoutineStepCategory;
import com.swyp3.skin.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoutineProduct extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private Routine routine;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(nullable = false)
    private Product product;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoutineStepCategory routineStepCategory;

    private String note;

    private String reason;

    public static RoutineProduct of(
            Routine routine,
            Product product,
            RoutineStepCategory routineStepCategory
    ) {
        RoutineProduct routineProduct = new RoutineProduct();
        routineProduct.routine = routine;
        routineProduct.product = product;
        routineProduct.routineStepCategory = routineStepCategory;
        return routineProduct;
    }
}
