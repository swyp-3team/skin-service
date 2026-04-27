package com.swyp3.skin.domain.routine.domain.enums;

import com.swyp3.skin.domain.product.domain.enums.ProductCategory;
import lombok.Getter;

@Getter
public enum RoutineStepCategory {

    PREPARE(1, "세안 후 피부결을 정돈하고 다음 단계 흡수를 높여줘요. 수분을 빠르게 채우고 피부 pH를 맞춰주는 첫 번째 레이어에요."),
    INTENSIVE_CARE(2, "피부 고민에 가장 직접적으로 작용하는 단계예요. 나에게 맞는 핵심 성분이 가장 고농도로 담겨 있어요."),
    MOISTURIZER(3, "수분과 영양이 날아기지 않도록 마무리해줘요. 피부 상태에 따라 가벼운 로션부터 진한 크림까지 선택할 수 있어요."),
    SUN_CARE(4, "낮 동안 자외선으로부터 피부를 보호해요. 어떤 루틴도 선크림 없이는 완성되지 않아요.");

    private final int order;
    private final String note;

    RoutineStepCategory(int order, String note) {
        this.order = order;
        this.note = note;
    }

    public static RoutineStepCategory from(ProductCategory category) {
        return switch (category) {
            case SKIN, TONER -> PREPARE;
            case ESSENCE, SERUM, AMPOULE -> INTENSIVE_CARE;
            case LOTION, EMULSION, CREAM -> MOISTURIZER;
            case SUN_CARE -> SUN_CARE;
        };
    }
}