package com.swyp3.skin.recommendation.core;

import com.swyp3.skin.domain.ingredient.domain.enums.IngredientGroup;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
import com.swyp3.skin.recommendation.model.enums.Concern;
import com.swyp3.skin.recommendation.model.enums.SkinState;
import com.swyp3.skin.recommendation.model.enums.SkinType;
import com.swyp3.skin.recommendation.model.test.TestCase;
import com.swyp3.skin.recommendation.testdata.TestData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class RecommendationEngineTest {

    @Test
    void test_acne_oily_case() {

        // STEP1 생략 → 직접 상태 벡터 생성
        Map<SkinState, Integer> state = Map.of(
                SkinState.DRYNESS, 40,
                SkinState.SEBUM, 70,
                SkinState.ACNE, 85,
                SkinState.SENSITIVITY, 55,
                SkinState.PIGMENTATION, 40
        );

        SkinInput input = new SkinInput(
                state,
                List.of(Concern.ACNE), // 고민
                SkinType.OILY          // 피부타입
        );

        RecommendationEngine engine = new RecommendationEngine();

        RecommendationResult result = engine.calculate(input);

        System.out.println("=== scores ===");
        result.getScores().forEach((k, v) ->
                System.out.println(k + " : " + v)
        );

        System.out.println("=== ranking ===");
        System.out.println(result.getRanking());
    }

    @Test
    void test_all_cases() {

        RecommendationEngine engine = new RecommendationEngine();

        int index = 1;

        for (TestCase tc : TestData.getTestCases()) {

            RecommendationResult result = engine.calculate(
                    new SkinInput(
                            tc.stateVector,
                            tc.concerns,
                            tc.skinType
                    )
            );

            List<IngredientGroup> top3 =
                    result.getRanking().stream().limit(3).toList();

            System.out.println("====================================");
            System.out.println("CASE #" + index);

            // 핵심만 찍기 (중요)
            System.out.println("INPUT: " + tc.concerns + " / " + tc.skinType);
            System.out.println("STATE: " + tc.stateVector);
            System.out.println("SCORES = " + result.getScores());
            System.out.println("TOP3 : " + top3);

            index++;
        }
    }

    @Test
    void 상세_테스트() {

        RecommendationEngine engine = new RecommendationEngine();

        List<TestCase> cases = List.of(

                // 극단 건조형
                new TestCase(
                        Map.of(
                                SkinState.DRYNESS, 85,
                                SkinState.SEBUM, 25,
                                SkinState.ACNE, 25,
                                SkinState.SENSITIVITY, 50,
                                SkinState.PIGMENTATION, 25
                        ),
                        List.of(Concern.DRY),
                        SkinType.DRY
                ),

                // 트러블 지성 폭발형
                new TestCase(
                        Map.of(
                                SkinState.DRYNESS, 25,
                                SkinState.SEBUM, 85,
                                SkinState.ACNE, 90,
                                SkinState.SENSITIVITY, 40,
                                SkinState.PIGMENTATION, 25
                        ),
                        List.of(Concern.ACNE),
                        SkinType.OILY
                ),

                // 민감 폭발형
                new TestCase(
                        Map.of(
                                SkinState.DRYNESS, 50,
                                SkinState.SEBUM, 25,
                                SkinState.ACNE, 25,
                                SkinState.SENSITIVITY, 90,
                                SkinState.PIGMENTATION, 25
                        ),
                        List.of(Concern.SENSITIVE),
                        SkinType.SENSITIVE
                ),

                // 애매한 인간형
                new TestCase(
                        Map.of(
                                SkinState.DRYNESS, 55,
                                SkinState.SEBUM, 55,
                                SkinState.ACNE, 55,
                                SkinState.SENSITIVITY, 55,
                                SkinState.PIGMENTATION, 55
                        ),
                        List.of(Concern.SENSITIVE),
                        SkinType.COMBINATION
                )
        );

        int idx = 1;

        for (TestCase tc : cases) {

            RecommendationResult result = engine.calculate(
                    new SkinInput(
                            tc.stateVector,
                            tc.concerns,
                            tc.skinType
                    )
            );

            System.out.println("====================================");
            System.out.println("CASE #" + idx++);
            System.out.println("INPUT: " + tc.concerns + " / " + tc.skinType);
            System.out.println("STATE: " + tc.stateVector);

            // 핵심 로그
            System.out.println("SCORES: " + result.getScores());

            // Top3 추출
            List<IngredientGroup> top3 = result.getRanking().stream()
                    .limit(3)
                    .toList();

            System.out.println("TOP3 : " + top3);
            System.out.println("====================================");
        }
    }

    @Test
    void 템플릿() {

        RecommendationEngine engine = new RecommendationEngine();

        TestCase testCase = new TestCase(
                Map.of(
                        SkinState.DRYNESS, 00,
                        SkinState.SEBUM, 00,
                        SkinState.ACNE, 00,
                        SkinState.SENSITIVITY, 00,
                        SkinState.PIGMENTATION, 00
                ),
                List.of(Concern.DRY),
                SkinType.DRY
        );

        RecommendationResult result = engine.calculate(
                new SkinInput(
                        testCase.stateVector,
                        testCase.concerns,
                        testCase.skinType
                )
        );

        System.out.println("====================================");
        System.out.println("INPUT: " + testCase.concerns + " / " + testCase.skinType);
        System.out.println("STATE: " + testCase.stateVector);

        // 핵심 로그
        System.out.println("SCORES: " + result.getScores());

        // Top3 추출
        List<IngredientGroup> top3 = result.getRanking().stream()
                .limit(3)
                .toList();

        System.out.println("TOP3 : " + top3);
        System.out.println("====================================");
    }
}
