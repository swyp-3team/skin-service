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

            Map.entry(1, new SkinTestSurveyQuestion(1, "세안 후 아무것도 안 바른 상태로 5분쯤 지나면, 얼굴이 당기는 느낌이 드나요?", options())),
            Map.entry(2, new SkinTestSurveyQuestion(2, "볼이나 눈가 주변에 각질이 일어나거나 잔주름이 잡히는 편인가요?", options())),
            Map.entry(3, new SkinTestSurveyQuestion(3, "보습제를 바른 직후엔 괜찮은데, 2~3시간 뒤에 다시 건조해지거나 각질이 일어나는 편인가요?", options())),

            Map.entry(4, new SkinTestSurveyQuestion(4, "오후에 거울을 봤을 때 이마나 코가 번들거리게 보이나요?", options())),
            Map.entry(5, new SkinTestSurveyQuestion(5, "세안 후 기초 제품을 바르고 나서도 얼마 안 돼 코나 이마가 번들거리는 편인가요?", options())),

            Map.entry(6, new SkinTestSurveyQuestion(6, "최근 한 달 동안 트러블이 새로 생긴 편인가요?", List.of(
                    new SkinTestSurveyOption(1, "거의 매일 생겨요"),
                    new SkinTestSurveyOption(2, "일주일에 1~2개는 생겨요"),
                    new SkinTestSurveyOption(3, "한 달에 몇 개 정도 생겨요"),
                    new SkinTestSurveyOption(4, "아주 가끔 생겨요"),
                    new SkinTestSurveyOption(5, "거의 안 생겨요")
            ))),
            Map.entry(7, new SkinTestSurveyQuestion(7, "트러블이 생길 때, 빨갛게 부어오르거나 곪는 형태로 올라오는 편인가요?", options())),

            Map.entry(8, new SkinTestSurveyQuestion(8, "새 화장품을 처음 사용했을 때 따갑거나 붉어진 경험이 있나요?", options())),
            Map.entry(9, new SkinTestSurveyQuestion(9, "세안 후나 마스크를 오래 쓴 뒤에 볼이 붉어지거나 열감이 느껴지나요?", options())),

            Map.entry(10, new SkinTestSurveyQuestion(10, "볼이나 광대 쪽에 옅은 갈색 얼룩이나 잡티가 신경 쓰이나요?", options())),
            Map.entry(11, new SkinTestSurveyQuestion(11, "거울로 봤을 때 얼굴 피부톤이 전체적으로 칙칙하거나 고르지 않다고 느끼나요?", options())),

            Map.entry(12, new SkinTestSurveyQuestion(12, "웃거나 표정 지을 때 눈가·입가에 생긴 주름이, 표정을 풀어도 잘 안 펴지고 남아있는 편인가요?", options())),
            Map.entry(13, new SkinTestSurveyQuestion(13, "볼 살이 처진 느낌이 있거나, 턱선이 예전보다 덜 선명해진 것 같다고 느끼나요?", options())),

            Map.entry(14, new SkinTestSurveyQuestion(14, "현재 고민을 선택해 주세요", concernOptions())),
            Map.entry(15, new SkinTestSurveyQuestion(15, "피부 타입을 선택해 주세요", skinTypeOptions()))

    );

    private static List<SkinTestSurveyOption> options() {
        return List.of(
                new SkinTestSurveyOption(1, "전혀 아니다"),
                new SkinTestSurveyOption(2, "아니다"),
                new SkinTestSurveyOption(3, "보통이다"),
                new SkinTestSurveyOption(4, "그렇다"),
                new SkinTestSurveyOption(5, "매우 그렇다")
        );
    }

    private static List<SkinTestSurveyOption> concernOptions() {
        return List.of(
                new SkinTestSurveyOption(null, "건조", Concern.DRY.name()),
                new SkinTestSurveyOption(null, "트러블", Concern.ACNE.name()),
                new SkinTestSurveyOption(null, "색소", Concern.PIGMENTATION.name()),
                new SkinTestSurveyOption(null, "탄력/주름", Concern.AGING.name()),
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
