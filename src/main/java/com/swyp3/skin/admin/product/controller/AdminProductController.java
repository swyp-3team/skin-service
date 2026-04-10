package com.swyp3.skin.admin.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/products")
@RequiredArgsConstructor
public class AdminProductController {


    @GetMapping
    public String productPage() {
        return "admin/product/index";
    }

    @GetMapping("/new")
    public String productCreatePage() {
        return "admin/product/form";
    }
}
