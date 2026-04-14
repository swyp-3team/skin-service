package com.swyp3.skin.api.v1.skintest.survey;

// 응답 DTO가 아닌 설문 문항 정의시에 사용
public record SkinTestSurveyOption(
        Integer optionNumber,
        String content,
        String code
) {
    public SkinTestSurveyOption(Integer optionNumber, String content) {
        this(optionNumber, content, null);
    }
}

