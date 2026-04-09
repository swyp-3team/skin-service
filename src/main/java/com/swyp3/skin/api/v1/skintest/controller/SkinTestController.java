package com.swyp3.skin.api.v1.skintest.controller;

import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
import com.swyp3.skin.api.v1.skintest.dto.request.PreviewRequest;
import com.swyp3.skin.api.v1.skintest.dto.response.MySkinTestResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestPreviewResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestStepMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestion;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestions;
import com.swyp3.skin.domain.skinttest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skinttest.exception.SkinTestException;
import com.swyp3.skin.global.response.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Skin Test", description = "피부진단 / 온보딩")
@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SkinTestController {


    @Operation(
            summary = "설문 단계 조회",
            description = "특정 단계의 질문, 선택지 를 반환합니다."
    )
    @GetMapping("/surveys")
    public ApiResponse<SkinTestStepResponse> getSurvey(
            @RequestParam @Min(1) int step
            ) {
        SkinTestSurveyQuestion question = SkinTestSurveyQuestions.QUESTIONS.get(step);

        if (question == null) {
            throw new SkinTestException(SkinTestErrorCode.INVALID_SURVEY_STEP);
        }

        // TODO : 14,15 번 step의 경우 고민,타입 반환 해야함

        SkinTestStepResponse response = SkinTestStepMapper.toResponse(question);
        return ApiResponse.ok(response);
    }

    @Operation(
            summary = "성분 추천만 확인",
            description = "프론트에서 받은 설문값들을 기반으로 추천 성분 추출후 반환합니다."
    )
    @PostMapping("/result/preview")
    public ApiResponse<SkinTestPreviewResponse> preview(
            @Valid @RequestBody SkinTestPreviewRequest request) {

        return ApiResponse.ok(SkinTestPreviewResponse);
    }

//    @Operation(
//            summary = "이전 단계 이동",
//            description = "이전 설문 단계의 질문과 선택지 그리고 기존 선택값 조회"
//    )
//    @GetMapping("/step/{step}/prev")
//    public ApiResponse<SkinTestStepResponse> prevStep(
//            @PathVariable int step,
//            HttpSession httpSession) {
//        //TODO : 현재 스탭 - 1  질문/선택지 조회
//        // 세션에서 이전 단계 저장 답변 추출
//        // selectedAnswer에 넣어서 응답
//        return null;
//    }

//    @Operation(
//            summary = "진단 완료",
//            description = "세션에 저장된 설문 답변을 기반으로 피부 타입과 추천 성분 결과를 계산합니다."
//    )
//    @PostMapping("/complete")
//    public ApiResponse<Void> complete(HttpSession httpSession){
//        //TODO : 세션 답변 읽고
//        // 세션 설문 답변 조회
//        // 상태 점수 계산
//        // 성분군 원점수 계산
//        // 정규화
//        // 고민 가중치 적용
//        // 피부타입 보정
//        // 최종 성분군 점수 및 우선순위 계산
//        // 상위 성분군 기준 대표 성분 추출
//        // 세션에 결과 저장
//        return ApiResponse.ok();
//    }

    @Operation(
            summary = "결과 조회",
            description = "세션에 저장된 피부 진단 결과를 조회합니다.")
    @GetMapping("/result")
    public ApiResponse<SkinTestResultResponse> getResult(HttpSession session) {
        // TODO: 세션 결과 반환
        return null;
    }

    @Operation(
            summary = "결과 DB 저장",
            description = "세션 결과를 로그인한 사용자의 진단 이력으로 저장합니다.")
    @PostMapping("/result/save")
    public ApiResponse<Void> saveResult() {
        // TODO: 세션 결과조회
        // SkinResult 저장
        // SkinResultScore 저장
        // SkinResultIngredient 저장
        return ApiResponse.ok();
    }

    @Operation(
            summary = "내 진단 조회",
            description = "로그인한 사용자의 최신 피부 진단 결과를 조회합니다.")
    @GetMapping("/result/me")
    public ApiResponse<MySkinTestResultResponse> getMyResult() {
        // TODO: 사용자 결과 조회
        return null;
    }
}
