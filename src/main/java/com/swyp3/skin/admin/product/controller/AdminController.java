package com.swyp3.skin.admin.product.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("admin")
public class AdminController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pageTitle", "Admin Dashboard");
        model.addAttribute("systemName", "Skin Service");
        model.addAttribute("userRole", "ADMIN");
        return "admin/index";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("userRole", "ADMIN");
        return "admin/product/index";
    }
}
