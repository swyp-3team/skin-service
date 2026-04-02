package com.swyp3.skin.api.v1.product.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product", description = "제품추천")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    @Operation(summary = "추천 제품 조회")
    @GetMapping("/recommend")
    public Object recommend(@RequestParam(required = false) String category,
                            @RequestParam int page,
                            @RequestParam int size) {
        return null;
    }

    @Operation(summary = "제품 상세 조회")
    @GetMapping("/{productId}")
    public Object getDetail(@PathVariable Long productId) {
        // TODO: 제품 상세 조회
        return null;
    }

    @Operation(summary = "제품 검색")
    @GetMapping("/search")
    public Object search(@RequestParam String keyword,
                         @RequestParam int page,
                         @RequestParam int size) {
        // TODO: 검색 로직
        return null;
    }
}
