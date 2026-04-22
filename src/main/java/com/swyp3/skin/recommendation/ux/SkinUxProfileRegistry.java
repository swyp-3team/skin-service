package com.swyp3.skin.recommendation.ux;

import com.swyp3.skin.domain.common.enums.IngredientGroup;

import java.util.List;
import java.util.Map;

public class SkinUxProfileRegistry {
    public SkinUxProfileRegistry() {
    }

    public static final Map<SkinUxKey, SkinUxProfile> PROFILES = Map.ofEntries(

            entry(
                    IngredientGroup.HYDRATION,
                    IngredientGroup.BARRIER,
                    "촉촉한 수분 결핍형",
                    "장벽까지 같이 약해진 상태예요",
                    "임시 데이터",
                    "임시 데이터",
                    List.of("임시"),
                    List.of(IngredientType.HYALURONIC_ACID)
            ),
            entry(
                    IngredientGroup.SEBUM_CONTROL,
                    IngredientGroup.ACNE,
                    "타입 네임",
                    "서브 타이블",
                    "설명1",
                    "설명2",
                    List.of("고민1", "고민2"),
                    List.of(IngredientType.HYALURONIC_ACID)
            )
    );
    private static Map.Entry<SkinUxKey, SkinUxProfile> entry(
            IngredientGroup top1,
            IngredientGroup top2,
            String typeName,
            String subtitle,
            String summary,
            String subSummary,
            List<String> concerns,
            List<IngredientType> ingredients
    ) {
        return Map.entry(
                SkinUxKey.of(top1, top2),
                new SkinUxProfile(
                        typeName,
                        subtitle,
                        summary,
                        subSummary,
                        concerns,
                        ingredients
                )
        );
    }

}
