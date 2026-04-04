package com.swyp3.skin.api.v1.auth.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "토큰 재발급 응답")
public record TokenRefreshResponse(
    @Schema(description = "재발급된 Access Token")
    String accessToken
) {
}
