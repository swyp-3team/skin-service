package com.swyp3.skin.api.v1.skintest.survey;

import com.swyp3.skin.recommendation.model.enums.Concern;
import com.swyp3.skin.recommendation.model.enums.SkinType;

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

            Map.entry(1, new SkinTestSurveyQuestion(1, "세안 후 피부가 당기나요?", options())),
            Map.entry(2, new SkinTestSurveyQuestion(2, "하루 중 피부가 건조함을 자주 느끼나요?", options())),
            Map.entry(3, new SkinTestSurveyQuestion(3, "세안 직후엔 괜찮지만 시간이 지나면 다시 건조해지나요?", options())),

            Map.entry(4, new SkinTestSurveyQuestion(4, "시간이 지나면 얼굴이 번들거리나요?", options())),
            Map.entry(5, new SkinTestSurveyQuestion(5, "T존(이마, 코)에 유분이 많이 올라오나요?", options())),

            Map.entry(6, new SkinTestSurveyQuestion(6, "여드름이나 트러블이 자주 발생하나요?", options())),
            Map.entry(7, new SkinTestSurveyQuestion(7, "염증성 트러블이 반복되나요?", options())),

            Map.entry(8, new SkinTestSurveyQuestion(8, "화장품 사용 시 자극을 느끼나요?", options())),
            Map.entry(9, new SkinTestSurveyQuestion(9, "피부가 쉽게 붉어지거나 따가운가요?", options())),

            Map.entry(10, new SkinTestSurveyQuestion(10, "잡티/기미가 신경 쓰이나요?", options())),
            Map.entry(11, new SkinTestSurveyQuestion(11, "피부톤이 균일하지 않다고 느끼나요?", options())),

            Map.entry(12, new SkinTestSurveyQuestion(12, "눈가나 팔자 주름이 신경 쓰이나요?", options())),
            Map.entry(13, new SkinTestSurveyQuestion(13, "피부 탄력이 예전보다 줄었다고 느끼나요?", options())),

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
                new SkinTestSurveyOption(null, "색소/잡티", Concern.PIGMENTATION.name()),
                new SkinTestSurveyOption(null, "주름/노화", Concern.AGING.name()),
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
