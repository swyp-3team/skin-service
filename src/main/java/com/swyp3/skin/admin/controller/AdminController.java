package com.swyp3.skin.admin.controller;

import com.swyp3.skin.admin.dashboard.dto.DashBoardResponse;
import com.swyp3.skin.admin.dashboard.service.AdminDashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminDashboardService adminDashboardService;

    @GetMapping
    public String index(Model model) {

        DashBoardResponse dashboard = adminDashboardService.getDashboard();

        model.addAttribute("pageTitle", "Admin Dashboard");
        model.addAttribute("systemName", "Layerd");
        model.addAttribute("userRole", "ADMIN");

        model.addAttribute("dashboard", dashboard);

        return "admin/index";
    }


}
