package com.swyp3.skin.api.v1.skintest.controller;

import com.swyp3.skin.api.v1.skintest.dto.request.SaveSkinResultRequest;
import com.swyp3.skin.api.v1.skintest.dto.request.SkinTestPreviewRequest;
import com.swyp3.skin.api.v1.skintest.dto.response.*;
import com.swyp3.skin.api.v1.skintest.mapper.SkinInputMapper;
import com.swyp3.skin.api.v1.skintest.mapper.SkinTestPreviewResponseMapper;
import com.swyp3.skin.domain.skintest.dto.SkinPreviewCacheValue;
import com.swyp3.skin.domain.skintest.service.SkinPreviewCacheService;
import com.swyp3.skin.domain.skintest.service.SkinTestApplicationService;
import com.swyp3.skin.global.auth.CustomUserDetails;
import com.swyp3.skin.global.response.dto.ApiResponse;
import com.swyp3.skin.recommendation.ingredient.model.RecommendationResult;
import com.swyp3.skin.recommendation.ingredient.model.SkinInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Skin Test", description = "피부진단 / 온보딩")
@Validated
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SkinTestController {

    private final SkinTestApplicationService skinTestApplicationService;
    private final SkinPreviewCacheService skinPreviewCacheService;

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
            summary = "성분 추천 미리보기",
            description = "미리보기 결과와 저장용 previewToken을 반환"
    )
    @PostMapping("/result/preview")
    public ApiResponse<SkinTestPreviewWithTokenResponse> preview(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @Valid @RequestBody SkinTestPreviewRequest request) {
        Long userId = userDetails.getUserId();
        SkinInput skinInput = skinInputMapper.toSkinInput(request);
        RecommendationResult result = skinTestApplicationService.calculate(skinInput);

        SkinTestPreviewResponse response = previewResponseMapper.toResponse(request.skinType(), result);
        String token = skinPreviewCacheService.put(new SkinPreviewCacheValue(userId, skinInput, result, response.summary()));
        return ApiResponse.ok(new SkinTestPreviewWithTokenResponse(response, token));
    }

    @Operation(
            summary = "결과 DB 저장",
            description = "사용자의 진단 이력 저장합니다.")
    @PostMapping("/result/save")
    public ApiResponse<Void> saveResult(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            @Valid @RequestBody SaveSkinResultRequest request
            ) {
        skinTestApplicationService.saveResult(userDetails.getUserId(), request.previewToken());
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
