package com.swyp3.skin.api.v1.auth.controller;

import com.swyp3.skin.api.v1.auth.dto.request.RefreshTokenRequest;
import com.swyp3.skin.api.v1.auth.dto.response.CurrentUserResponse;
import com.swyp3.skin.api.v1.auth.dto.response.TokenRefreshResponse;
import com.swyp3.skin.domain.auth.service.AuthApplicationService;
import com.swyp3.skin.global.auth.CustomUserDetails;
import com.swyp3.skin.global.response.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Auth", description = "인증 / JWT")
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthApplicationService authApplicationService;

    @Operation(summary = "현재 사용자 조회")
    @GetMapping("/me")
    public ApiResponse<CurrentUserResponse> getCurrentUser(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return ApiResponse.ok(authApplicationService.getCurrentUser(userDetails.getUserId()));
    }

    @Operation(summary = "AccessToken 재발급")
    @PostMapping("/refresh")
    public ApiResponse<TokenRefreshResponse> refreshToken(
            @Valid @RequestBody RefreshTokenRequest request
    ) {
        return ApiResponse.ok(authApplicationService.refresh(request.refreshToken()));
    }

    @Operation(summary = "로그아웃")
    @PostMapping("/logout")
    public ApiResponse<Void> logout(
            @AuthenticationPrincipal CustomUserDetails userDetails,
            HttpServletResponse response
    ) {
        authApplicationService.logout(userDetails.getUserId());

        // 쿠키 삭제 (AccessToken 무효화)
        Cookie cookie = new Cookie("accessToken", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return ApiResponse.ok();
    }
}
