package com.swyp3.skin.api.v1.skintest.controller;

import com.swyp3.skin.api.v1.skintest.dto.request.CompleteSkinTestRequest;
import com.swyp3.skin.api.v1.skintest.dto.request.SaveSkinTestAnswerRequest;
import com.swyp3.skin.api.v1.skintest.dto.response.MySkinTestResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.global.response.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Skin Test", description = "피부진단 / 온보딩")
@RestController
@RequestMapping("/api/v1/skin-test")
@RequiredArgsConstructor
public class SkinTestController {

    @Operation(
            summary = "설문 시작",
            description = "피부 진단 설문 세션을 초기화하고 첫 설문 단계 정보를 반환합니다."
    )
    @PostMapping("/start")
    public ApiResponse<SkinTestStepResponse> start(HttpSession session) {
        // TODO : 세션 초기화 (이전 정보 지우고 깨끗하게 시작)
        // selectedAnswer는 null로 내려준다
        return null;
    }

    @Operation(
            summary = "설문 단계 조회",
            description = "특정 단계의 질문, 선택지, 그리고 이미 저장된 선택값을 함께 조회합니다."
    )
    @GetMapping("/step/{step}")
    public ApiResponse<SkinTestStepResponse> getStep(
            @PathVariable int step,
            HttpSession session
    ) {
        // TODO:
        // 1. step 번호에 맞는 질문/선택지를 조회
        // 2. 세션(SKIN_SURVEY)에서 현재 step의 기존 답변을 조회
        // 3. selectedAnswer에 담아 프론트가 체크 상태를 표시

        // SkinTestSurveyQuestion question = SkinTestSurveyQuestions.QUESTIONS.get(step);
        // Integer selectedOption = getSelectedOptionFromSession(session, step);

        // SkinTestStepResponse response = SkinTestStepMapper.toResponse(question, selectedOption);
        // return ApiResponse.ok(response)

        return null;
    }

    @Operation(
            summary = "답변 저장",
            description = "현재 단계의 답변을 세션에 저장합니다."
    )
    @PostMapping("/step/{step}")
    public ApiResponse<Void> saveAnswer(
                           @PathVariable int step,
                           @Valid @RequestBody SaveSkinTestAnswerRequest request,
                           HttpSession httpSession) {
        //TODO : 세션에 저장(SKIN_SURVEY)
        // 저장시에는 필드명이 아닌 SaveSkinTestAnswerRequest 에서 Integer형태로 오기떄문에
        // Integer로 저장하여야함
        // 세션(SKIN_SURVEY)에 step -> answer형태 저장
        // 이미 저장되었으면 (재선택) 하면 덮어쓰기
        return ApiResponse.ok();
    }

    @Operation(
            summary = "이전 단계 이동",
            description = "이전 설문 단계의 질문과 선택지 그리고 기존 선택값 조회"
    )
    @GetMapping("/step/{step}/prev")
    public ApiResponse<SkinTestStepResponse> prevStep(
            @PathVariable int step,
            HttpSession httpSession) {
        //TODO : 현재 스탭 - 1  질문/선택지 조회
        // 세션에서 이전 단계 저장 답변 추출
        // selectedAnswer에 넣어서 응답
        return null;
    }

    @Operation(
            summary = "진단 완료",
            description = "세션에 저장된 설문 답변을 기반으로 피부 타입과 추천 성분 결과를 계산합니다."
    )
    @PostMapping("/complete")
    public ApiResponse<Void> complete(
            @Valid @RequestBody CompleteSkinTestRequest request,
            HttpSession httpSession){
        //TODO : 세션 답변 읽고
        // 세션 설문 답변 조회
        // 상태 점수 계산
        // 성분군 원점수 계산
        // 정규화
        // 고민 가중치 적용
        // 피부타입 보정
        // 최종 성분군 점수 및 우선순위 계산
        // 상위 성분군 기준 대표 성분 추출
        // 세션에 결과 저장
        return ApiResponse.ok();
    }

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
