package com.swyp3.skin.api.v1.skintest.mapper;

import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestions;
import com.swyp3.skin.domain.skinttest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skinttest.exception.SkinTestException;
import com.swyp3.skin.recommendation.model.SkinInput;
import com.swyp3.skin.recommendation.model.enums.SkinState;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Component
public class SkinInputMapper {

    public SkinInput toSkinInput(SkinTestPreviewRequest request) {
        HashMap<Integer, Integer> answerByStep = new HashMap<>();

        // 문항별 답변 목록 -> 설문 단계 번호
        for (SkinTestPreviewRequest.AnswerDto answer : request.answers()) {
            Integer step = answer.step();

            // 만약 질문목록에 해당 단계가 없다면 INVALID_SURVEY_STEP
            if (!SkinTestSurveyQuestions.QUESTIONS.containsKey(step)) {
                throw new SkinTestException(SkinTestErrorCode.INVALID_SURVEY_ANSWER_PAYLOAD);
            }
            // 만약 생성해둔 스토어에 똑같은 step이 들어온다면 => 중복스탭 처리니 INVALID_SURVEY_STEP
            if (answerByStep.putIfAbsent(step, answer.answer()) != null) {
                throw new SkinTestException(SkinTestErrorCode.INVALID_SURVEY_ANSWER_PAYLOAD);
            }
        }

        Map<SkinState, Integer> stateVector = new EnumMap<>(SkinState.class);
        stateVector.put(SkinState.DRYNESS, avg(answerByStep, 1, 2, 3));
        stateVector.put(SkinState.SEBUM, avg(answerByStep, 4, 5));
        stateVector.put(SkinState.ACNE, avg(answerByStep, 6, 7));
        stateVector.put(SkinState.SENSITIVITY, avg(answerByStep, 8, 9));
        stateVector.put(SkinState.PIGMENTATION, avg(answerByStep, 10, 11));
        stateVector.put(SkinState.AGING, avg(answerByStep, 12, 13));

        return new SkinInput(stateVector, request.concerns(), request.skinType());
    }

    // 답변들의 평균값 계산                                              // 호출시 자동으로 배열 생성되는 문법
    private int avg(Map<Integer, Integer> answerByStep, int... steps) {
        int sum = 0;
        int count = 0;

        for (int step : steps) {
            Integer answer = answerByStep.get(step);
            if (answer != null) {
                sum += answerToScore(answer);
                count++;
            }
        }

        // 미응답 축은 중립값 처리
        return count == 0 ? 55 : (sum / count);
    }

    private int answerToScore(int answer) {
        return switch (answer) {
            case 1 -> 25;
            case 2 -> 40;
            case 3 -> 55;
            case 4 -> 70;
            case 5 -> 85;
            default -> throw new SkinTestException(SkinTestErrorCode.INVALID_SURVEY_ANSWER_PAYLOAD);
        };
    }
}
