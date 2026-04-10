package com.swyp3.skin.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pageTitle", "Admin Dashboard");
        model.addAttribute("systemName", "Layerd");
        model.addAttribute("userRole", "ADMIN");
        return "admin/index";
    }


}
