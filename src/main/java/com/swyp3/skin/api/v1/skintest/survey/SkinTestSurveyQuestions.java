package com.swyp3.skin.api.v1.skintest.survey;

import com.swyp3.skin.recommendation.ingredient.model.enums.Concern;
import com.swyp3.skin.recommendation.ingredient.model.enums.SkinType;

import java.util.List;
import java.util.Map;

/*
 * 피부 진단 설문을 step 기준으로 관리하는 클래스
 * 사용방식 :
 * - key: step(설문단계)
 * - value : 해당 단계의 질문/선택지 정보
 * 질문이 늘어나는데로 QUESTIONS맵에 step단위로 계속 추가
 */
public final class SkinTestSurveyQuestions {

    private SkinTestSurveyQuestions() {
        // 외부 생성 금지
    }

    // step기준으로 설문 문항 조회하기 위한 고정데이터 저장소

    public static final Map<Integer, SkinTestSurveyQuestion> QUESTIONS = Map.ofEntries(

            Map.entry(1, new SkinTestSurveyQuestion(1, "세안 후 아무것도 바르지 않은 상태로 5분 정도 지나면 얼굴이 당기는 느낌이 드나요?", options())),
            Map.entry(2, new SkinTestSurveyQuestion(2, "볼이나 눈가에 각질이 일어나거나 잔주름이 잡히는 편인가요?", options())),
            Map.entry(3, new SkinTestSurveyQuestion(3, "보습제를 바른 직후엔 괜찮은데 2~3시간 뒤에 다시 건조해지나요?", options())),

            Map.entry(4, new SkinTestSurveyQuestion(4, "기초 제품을 다 바르고 나서 코나 이마에 유분이 올라오는 편인가요?", options())),
            Map.entry(5, new SkinTestSurveyQuestion(5, "오후가 되면 피부가 번들거리나요?", options())),

            Map.entry(6, new SkinTestSurveyQuestion(6, "여드름, 뾰루지 등 좁쌀 피부 트러블이 얼마나 자주 생기는 편인가요?", List.of(
                    new SkinTestSurveyOption(1, "일주일에 2~3개 이상 생겨요"),
                    new SkinTestSurveyOption(2, "일주일에 1개 정도 생겨요"),
                    new SkinTestSurveyOption(3, "한 달에 몇 개 정도 생겨요"),
                    new SkinTestSurveyOption(4, "아주 가끔 생겨요"),
                    new SkinTestSurveyOption(5, "거의 생기지 않아요")
            ))),
            Map.entry(7, new SkinTestSurveyQuestion(7, "트러블이 생길 때, 빨갛게 붓거나 누르면 아픈 형태로 올라오는 편인가요?", options())),

            Map.entry(8, new SkinTestSurveyQuestion(8, "새로운 화장품 사용으로 따갑거나 붉어진 경험이 있나요?", options())),
            Map.entry(9, new SkinTestSurveyQuestion(9, "세안 후나 마스크를 오래 쓴 뒤에 볼이 붉어지거나 화끈한 느낌이 드나요?", options())),

            Map.entry(10, new SkinTestSurveyQuestion(10, "볼이나 광대 쪽에 옅은 갈색 얼룩이나 잡티가 신경 쓰이나요?", options())),
            Map.entry(11, new SkinTestSurveyQuestion(11, "얼굴 피부톤이 전체적으로 칙칙하게 느껴지나요?", options())),

            Map.entry(12, new SkinTestSurveyQuestion(12, "눈가나 입가에 잔주름이 신경 쓰이나요?", options())),
            Map.entry(13, new SkinTestSurveyQuestion(13, "피부가 처지는 느낌이 들거나 탄력이 줄었다고 느끼나요?", options())),

            Map.entry(14, new SkinTestSurveyQuestion(14, "지금 가장 먼저 해결하고 싶은 피부 고민은 무엇인가요?", concernOptions())),
            Map.entry(15, new SkinTestSurveyQuestion(15, "스스로 생각하는 본인의 피부 유형은 무엇인가요?", skinTypeOptions()))

    );

    private static List<SkinTestSurveyOption> options() {
        return List.of(
                new SkinTestSurveyOption(5, "항상 그래요"),
                new SkinTestSurveyOption(4, "자주 그런 편이에요"),
                new SkinTestSurveyOption(3, "가끔 그래요"),
                new SkinTestSurveyOption(2, "거의 없어요"),
                new SkinTestSurveyOption(1, "전혀 없어요")
        );
    }

    private static List<SkinTestSurveyOption> concernOptions() {
        return List.of(
                new SkinTestSurveyOption(null, "건조", Concern.DRY.name()),
                new SkinTestSurveyOption(null, "트러블", Concern.ACNE.name()),
                new SkinTestSurveyOption(null, "색소", Concern.PIGMENTATION.name()),
                new SkinTestSurveyOption(null, "탄력", Concern.AGING.name()),
                new SkinTestSurveyOption(null, "민감", Concern.SENSITIVE.name()),
                new SkinTestSurveyOption(null, "피지", Concern.SEBUM.name()),
                new SkinTestSurveyOption(null, "모공", Concern.PORE.name())

        );
    }

    private static List<SkinTestSurveyOption> skinTypeOptions() {
        return List.of(
                new SkinTestSurveyOption(null, "건성", SkinType.DRY.name()),
                new SkinTestSurveyOption(null, "지성", SkinType.OILY.name()),
                new SkinTestSurveyOption(null, "복합성", SkinType.COMBINATION.name()),
                new SkinTestSurveyOption(null, "민감성", SkinType.SENSITIVE.name()),
                new SkinTestSurveyOption(null, "잘 모르겠어요", SkinType.UNKNOWN.name())
        );
    }
}
