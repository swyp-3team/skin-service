package com.swyp3.skin.api.v1.auth.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "인증 / JWT")
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Operation(summary = "현재 사용자 조회")
    @GetMapping("/me")
    public Object getCurrentUser() {
        // TODO : SecurityContext에서 사용자 조회
        return null;
    }

    @Operation(summary = "AccessToken 재발급")
    @PostMapping("/refresh")
    public Object refreshToken(@RequestBody Object request) {
        // TODO : refreshToken 검증후 accessToken 재발급
        return null;
    }

    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public void logout() {
        // TODO : RefreshToken 무효화
    }
}
