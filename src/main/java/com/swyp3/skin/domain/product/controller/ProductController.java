package com.swyp3.skin.domain.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Product", description = "제품 추천 컨트롤러")
@Controller
@RequestMapping("/products")
public class ProductController {

    @Operation(summary = "제품 추천 페이지", description = "피부정보 없으면 설문 redirect && 로그인 필수")
    @GetMapping("/recommend")
    public String recommendPage(HttpSession session, Model model) {

        /*
         * TODO 우선은 이렇게 설정해두었지만 추후에 User정보에서 꺼내쓰는 방식으로 전환 고려
         */
        Object result = session.getAttribute("SKIN_RESULT");

        if (result == null) {
            // TODO 바로 redirect 말고 알림 띄우는 방식 고려
            return "redirect:/skin-test/start";
        }

        // TODO 피부타입/성분 기반 제품 추천 로직 (Product DB 확정 후 작성)
        model.addAttribute("result", result);
        return "product/recommend";
    }

    @Operation(summary = "제품 상세 페이지", description = "productId 기반 조회 · 미정 기능")
    @GetMapping("/{productId}")
    public String productDetailPage(@PathVariable Long productId, Model model) {
        // TODO Product DB 확정 및 필요한지 확인후 작성
        return "product/detail";
    }
}
