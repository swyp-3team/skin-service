package com.swyp3.skin.api.v1.user.controller;

import com.swyp3.skin.api.v1.user.dto.response.MyPageResponse;
import com.swyp3.skin.domain.user.service.UserService;
import com.swyp3.skin.global.auth.CustomUserDetails;
import com.swyp3.skin.global.response.dto.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "사용자 정보")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public ApiResponse<MyPageResponse> getMyPage(
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        Long userId = userDetails.getUserId();
        MyPageResponse response = userService.getMyPageInfo(userId);
        return ApiResponse.ok(response);
    }
}
