package com.swyp3.skin.api.v1.skintest.survey;

import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestQuestionOptionResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;

public final class SkinTestStepMapper {

    private SkinTestStepMapper() {
        // 외부 생성 금지
    }

    /* 실제 사용시 아래와 같이 사용
     * SkinTestSurveyQuestion question = SkinTestSurveyQuestions.QUESTIONS.get(step);
     * SkinTestStepResponse response = SkinTestStepMapper.toResponse(question);
     * return ApiResponse.ok(response)
     */
    public static SkinTestStepResponse toResponse(SkinTestSurveyQuestion question) {
        return new SkinTestStepResponse(
                question.step(),
                question.question(),
                question.options().stream()
                        // 내부 설문 선택지는 현재 SkinTestSurveyOption 형태로 저장되어있음
                        // streamAPI를 사용하여 SkinTestSurveyOption -> SkinTestQuestionOptionResponse 로 변환
                        // list형태로 변환하여 SkinTestStepResponse 의 options 필드 채우기
                        .map(option -> new SkinTestQuestionOptionResponse(
                                option.optionNumber(),
                                option.content(),
                                option.code()
                        ))
                        .toList()
        );
    }
}
