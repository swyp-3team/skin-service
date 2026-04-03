package com.swyp3.skin.api.v1.auth.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "현재 사용자 응답 정보")
public record CurrentUserResponse(

        @Schema(description = "사용자 ID", example = "1")
        Long userId,

        @Schema(description = "닉네임", example = "skinlover")
        String nickname,

        @Schema(description = "권한", example = "USER")
        String role,

        @Schema(description = "프로필 이미지 URL", example = "https://cdn.example.com/profile.png")
        String profileImageUrl
        ) {
}
