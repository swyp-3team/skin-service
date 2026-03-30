package com.swyp3.skin.domain.skintest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "SkinTest", description = "피부 진단 컨트롤러")
@Controller
@RequestMapping("/skin-test")
public class SkinTestController {

    private static final int LAST_STEP = 6; // 총 질문 수 확정되면 변경

    @Operation(summary = "설문 시작", description = "세션 초기화 · 기존 설문 데이터 있으면 초기화 처리")
    @GetMapping("/start")
    public String skinTestStart(HttpSession session) {

        session.removeAttribute("SKIN_SURVEY");
        session.removeAttribute("SKIN_RESULT");

        session.setAttribute("SKIN_SURVEY", new HashMap<Integer, Integer>()); // 해당코드가 추후 스탭별로 답변 세션저장
        return "redirect:/skin-test/step/1";
    }

    @Operation(summary = "단계별 질문 페이지", description = "step: 1~N · 세션에서 기존 답변 불러와 렌더")
    @GetMapping("/step/{step}")
    public String skinTestStepPage(@PathVariable int step,
                                   HttpSession session,
                                   Model model) {
        Map<Integer, Integer> survey = (Map<Integer, Integer>) session.getAttribute("SKIN_SURVEY");
        // 세션 없으면 처음부터 (세션이 없다 => 사용자가 URL에 직접입력)
        if (survey == null) {
            return "redirect:/skin-test/start";
        }

        model.addAttribute("step", step);
        model.addAttribute("survey", survey); // 이전 답변 복원용 (3번질문에서 -> 2번질문 으로 이동하면 2번질문 답변랜더위해)
        return "skin-test/step";
    }

    @Operation(summary = "단계별 답변 저장", description = "세션에 저장 후 다음 단계 또는 결과 페이지 redirect")
    @PostMapping("/step/{step}")
    public String skinTestStepSave(@PathVariable int step,
                                   @RequestParam int answer,
                                   HttpSession session) {
        Map<Integer, Integer> survey = (Map<Integer, Integer>) session.getAttribute("SKIN_SURVEY");

        // 세션 없으면 처음부터 (세션이 없다 => 사용자가 URL에 직접입력)
        if (survey == null) {
            return "redirect:/skin-test/start";
        }

        survey.put(step, answer); // ex) 1=2, 2=1 ...
        session.setAttribute("SKIN_SURVEY", survey);

        if (step >= LAST_STEP) {
            //TODO SKIN_RESULT 생성로직 결정시 이부분 추가 예정
            return "redirect:/skin-test/result";
        }
        return "redirect:/skin-test/step/" + (step + 1);
    }

    @Operation(summary = "진단 결과 페이지", description = "세션의 결과 데이터 렌더 · 비로그인 포함 · 로그인 유도 CTA")
    @GetMapping("/result")
    public String skinTestResult(HttpSession session, Model model) {
        Map<Integer, Integer> survey = (Map<Integer, Integer>) session.getAttribute("SKIN_SURVEY");
        Object result = session.getAttribute("SKIN_RESULT");

        // 세션 없으면 처음부터 (세션이 없다 => 사용자가 URL에 직접입력)
        if (survey == null || survey.isEmpty()) {
            return "redirect:/skin-test/start";
        }

        //TODO result 값을 어떻게 활용할지 결정되면 이부분 추가 예정
        model.addAttribute("result", result);
        return "skin-test/result";
    }
}