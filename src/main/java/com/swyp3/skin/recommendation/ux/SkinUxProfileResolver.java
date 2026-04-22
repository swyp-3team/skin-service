package com.swyp3.skin.recommendation.ux;

import com.swyp3.skin.domain.common.enums.IngredientGroup;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SkinUxProfileResolver {

    public Optional<SkinUxProfile> resolve(IngredientGroup top1, IngredientGroup top2) {

        if (top1 == null || top2 == null) {
            return Optional.empty();
        }

        if (top1 == IngredientGroup.TURNOVER) {
            return Optional.ofNullable(
                    SkinUxProfileRegistry.PROFILES.get(SkinUxKey.of(top2, top1))
            );
        }

        return Optional.ofNullable(
                SkinUxProfileRegistry.PROFILES.get(SkinUxKey.of(top1, top2))
        );
    }
}
