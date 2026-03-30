package com.swyp3.skin.domain.routine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Routine", description = "루틴 관리 컨트롤러")
@Controller
@RequestMapping("/routine")
public class RoutineController {

    @Operation(summary = "루틴 진입 페이지", description = "AM / PM 선택 UI")
    @GetMapping("")
    public String routinePage() {
        return "routine/index";
    }

    @Operation(summary = "제품 선택 페이지", description = "hidden 또는 쿼리파라미터로 ROUTINE_TYPE 수신")
    @GetMapping("/products")
    public String routineProductsPage(@RequestParam String routineType, Model model) {
        /*
         * TODO 제품 선택페이지를 따로 해야할지 아니면 검색후 체크를 통해 추가하는 방식으로 갈지
         */
        model.addAttribute("routineType", routineType);
        return "routine/products";
    }

    @Operation(summary = "루틴 등록", description = "userId + ROUTINE_TYPE + 제품 리스트 → UserRoutine 저장")
    @PostMapping("")
    public String routineSave(@RequestParam String routineType,
                              @RequestParam List<Long> productIds,
                              @AuthenticationPrincipal CustomUserDetails userDetails) {
        // TODO UserRoutine 생성 로직 (Routine DB 확정 후 작성)
        return "redirect:/routine/result";
    }

    @Operation(summary = "루틴 결과 페이지", description = "사용순서 + 경고/개선 제안 렌더")
    @GetMapping("/result")
    public String routineResultPage(Model model) {
        // TODO : 순서 추천 + 성분 충돌 검사 결과 렌더 (로직 확정 후 작성)
        return "routine/result";
    }

    @Operation(summary = "내 루틴 조회 페이지", description = "userId + AM/PM 필터링 · 마이페이지 연계")
    @GetMapping("/my")
    public String myRoutinePage(@RequestParam(required = false) String routineType,
                                @AuthenticationPrincipal CustomUserDetails userDetails,
                                Model model) {
        // TODO 마이페이지여부 가 결정되면 그떄 추가 작성
        model.addAttribute("routineType", routineType);
        return "routine/my";
    }
}