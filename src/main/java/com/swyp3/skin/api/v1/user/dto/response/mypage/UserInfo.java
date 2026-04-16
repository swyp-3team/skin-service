package com.swyp3.skin.api.v1.user.dto.response.mypage;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "사용자 정보")
public record UserInfo(

        @Schema(description = "사용자 이름", example = "홍길동")
        String name,
        @Schema(description = "사용자 이메일", example = "example.gamil.com")
        String email,

        @Schema(description = "사용자 프로필 이미지 URL", example = "https://example.com/profile.jpg")
        String profileImageUrl
) {
    public static UserInfo from(String name, String email, String profileImageUrl) {
        return new UserInfo(name, email, profileImageUrl);
    }
}
