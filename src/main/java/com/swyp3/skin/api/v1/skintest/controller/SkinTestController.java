package com.swyp3.skin.api.v1.skintest.controller;

import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
import com.swyp3.skin.api.v1.skintest.dto.response.MySkinTestResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestPreviewResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestResultResponse;
import com.swyp3.skin.api.v1.skintest.dto.response.SkinTestStepResponse;
import com.swyp3.skin.api.v1.skintest.mapper.SkinInputMapper;
import com.swyp3.skin.api.v1.skintest.mapper.SkinTestPreviewResponseMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestStepMapper;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestion;
import com.swyp3.skin.api.v1.skintest.survey.SkinTestSurveyQuestions;
import com.swyp3.skin.domain.skinttest.exception.SkinTestErrorCode;
import com.swyp3.skin.domain.skinttest.exception.SkinTestException;
import com.swyp3.skin.domain.skinttest.service.SkinTestApplicationService;
import com.swyp3.skin.global.response.dto.ApiResponse;
import com.swyp3.skin.recommendation.model.RecommendationResult;
import com.swyp3.skin.recommendation.model.SkinInput;
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

    private final SkinTestApplicationService skinTestApplicationService;
    private final SkinInputMapper skinInputMapper;
    private final SkinTestPreviewResponseMapper previewResponseMapper;

    @Operation(
            summary = "설문 단계 조회",
            description = "특정 단계의 질문, 선택지 를 반환합니다."
    )
    @GetMapping("/surveys")
    public ApiResponse<SkinTestStepResponse> getSurvey(
            @RequestParam @Min(1) int step
            ) {
        return ApiResponse.ok(skinTestApplicationService.getSurveyStep(step));
    }

    @Operation(
            summary = "성분 추천만 확인",
            description = "프론트에서 받은 설문값들을 기반으로 추천 성분 추출후 반환합니다."
    )
    @PostMapping("/result/preview")
    public ApiResponse<SkinTestPreviewResponse> preview(
            @Valid @RequestBody SkinTestPreviewRequest request) {

        SkinInput skinInput = skinInputMapper.toSkinInput(request);
        RecommendationResult result = skinTestApplicationService.calculate(skinInput);
        SkinTestPreviewResponse response = previewResponseMapper.toResponse(request.skinType(), result);
        return ApiResponse.ok(response);
    }

    @Operation(
            summary = "결과 DB 저장",
            description = "사용자의 진단 이력 저장합니다.")
    @PostMapping("/result/save")
    public ApiResponse<Void> saveResult() {
        // TODO: 세션을결과조회
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
