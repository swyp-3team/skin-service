package com.swyp3.skin.global.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Tag(name = "Page", description = "페이지 라우팅 컨트롤러")
@Controller
public class PageController {

    @Operation(summary = "랜딩 페이지", description = "비로그인 사용자 진입점")
    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    @Operation(summary = "메인 페이지", description = "로그인 사용자 redirect 대상")
    @GetMapping("/main")
    public String mainPage() {
        return "main";
    }

    @Operation(summary = "온보딩 페이지", description = "최초 로그인 사용자 redirect 대상")
    @GetMapping("/onboarding")
    public String onboardingPage() {
        return "onboarding";
    }
}