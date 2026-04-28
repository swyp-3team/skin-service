package com.swyp3.skin.admin.users.controller;

import com.swyp3.skin.admin.users.dto.AdminUserResponse;
import com.swyp3.skin.admin.users.service.AdminUserService;
import com.swyp3.skin.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;
    private final UserService userService;

    @GetMapping
    public String getUsers(Pageable pageable, Model model) {
        Page<AdminUserResponse> users = adminUserService.getUsers(pageable);
        model.addAttribute("users", users);
        return "admin/users/list";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(
            @PathVariable Long id
    ) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
