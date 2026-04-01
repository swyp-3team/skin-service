package com.swyp3.skin.api.v1.skintest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Skin Test", description = "피부진단 / 온보딩")
@RestController
@RequestMapping("/api/v1/skin-test")
@RequiredArgsConstructor
public class SkinTestController {

    @Operation(summary = "설문 시작")
    @PostMapping("/start")
    public void start(HttpSession session) {
        // TODO : 세션 초기화 (이전 정보 지우고 깨끗하게 시작)
    }

    @Operation(summary = "설문 단계 조회")
    @GetMapping("/step/{step}")
    public Object getStep(@PathVariable int step) {
        // TODO : 질문 + 선택지
        return null;
    }

    @Operation(summary = "답변 저장")
    @PostMapping("/step/{step}")
    public void saveAnswer(@PathVariable int step,
                           @RequestBody Object request,
                           HttpSession httpSession) {
        //TODO : 세션에 저장(SKIN_SURVEY)
    }

    @Operation(summary = "이전 단계 이동")
    @GetMapping("/step/{step}/prev")
    public Object prevStep(@PathVariable int step) {
        //TODO : 이전 질문 반환
        return null;
    }

    @Operation(summary = "진단완료")
    @PostMapping("/complete")
    public void complete(HttpSession httpSession){
        //TODO : 결과 계산 -> 세션 저장
    }

    @Operation(summary = "결과 조회 (비로그인)")
    @GetMapping("/result")
    public Object getResult(HttpSession session) {
        // TODO: 세션 결과 반환
        return null;
    }

    @Operation(summary = "결과 DB 저장")
    @PostMapping("/result/save")
    public void saveResult() {
        // TODO: 세션 → DB 저장
    }

    @Operation(summary = "내 진단 조회")
    @GetMapping("/result/me")
    public Object getMyResult() {
        // TODO: 사용자 결과 조회
        return null;
    }
}
