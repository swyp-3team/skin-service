package com.swyp3.skin.api.v1.skintest.survey;

import java.util.List;

// 설문의 한 단계를 구성하는 데이터
// step 번호 , 질문 문구 , 선택지 목록을 함께 보관
public record SkinTestSurveyQuestion(
    Integer step, // 설문 단계
    String question, // 설문 질문
    List<SkinTestSurveyOption> options // 설문 선택지
) {
}
