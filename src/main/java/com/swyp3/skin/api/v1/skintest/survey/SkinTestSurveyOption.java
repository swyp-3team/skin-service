package com.swyp3.skin.api.v1.skintest.survey;

// 응답 DTO가 아닌 설문 문항 정의시에 사용
public record SkinTestSurveyOption(
        Integer optionNumber, // 설문 선택지 번호(결과 저장시 Integer로 저장하기 떄문)
        String content // 설문 선택지 멘트(전혀 아니다,보통이다 등)
) {
}
