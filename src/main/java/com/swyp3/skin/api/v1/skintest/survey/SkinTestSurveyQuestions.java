package com.swyp3.skin.api.v1.skintest.survey;

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

    public static final Map<Integer, SkinTestSurveyQuestion> QUESTIONS = Map.of(
            1, new SkinTestSurveyQuestion(
                    1,
                    "세안후 피부가 당기나요?",
                    List.of(
                            new SkinTestSurveyOption(1, "전혀 아니다"),
                            new SkinTestSurveyOption(2, "아니다"),
                            new SkinTestSurveyOption(3, "보통이다"),
                            new SkinTestSurveyOption(4, "그렇다"),
                            new SkinTestSurveyOption(5, "매우 그렇다")
                    )
            )
    );
}
