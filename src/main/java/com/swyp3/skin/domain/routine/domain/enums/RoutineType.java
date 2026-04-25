package com.swyp3.skin.domain.routine.domain.enums;

import com.swyp3.skin.domain.product.domain.enums.ProductUsageTime;

import java.util.List;

public enum RoutineType { AM, PM;

    public static List<RoutineType> from(ProductUsageTime usageTime) {
        return switch (usageTime) {
            case AM -> List.of(AM);
            case PM -> List.of(PM);
            case BOTH -> List.of(AM, PM);
        };
    }
}
