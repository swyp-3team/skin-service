package com.swyp3.skin.api.v1.auth.controller;

import com.swyp3.skin.api.v1.auth.dto.request.RefreshTokenRequest;
import com.swyp3.skin.api.v1.auth.dto.response.CurrentUserResponse;
import com.swyp3.skin.api.v1.auth.dto.response.TokenRefreshResponse;
import com.swyp3.skin.global.response.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "인증 / JWT")
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    @Operation(summary = "현재 사용자 조회")
    @GetMapping("/me")
    public ApiResponse<CurrentUserResponse> getCurrentUser() {
        // TODO : SecurityContext에서 사용자 조회
        return null;
    }

    @Operation(summary = "AccessToken 재발급")
    @PostMapping("/refresh")
    public ApiResponse<TokenRefreshResponse> refreshToken(
            @Valid @RequestBody RefreshTokenRequest request
    ) {
        // TODO : refreshToken 검증후 accessToken 재발급
        return null;
    }

    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ApiResponse<Void> logout() {
        // TODO : RefreshToken 무효화
        return ApiResponse.ok();
    }
}
