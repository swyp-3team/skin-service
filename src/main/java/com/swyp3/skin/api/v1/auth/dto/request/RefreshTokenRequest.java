package com.swyp3.skin.api.v1.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "AccessToken 재발급 요청")
public record RefreshTokenRequest(
    @NotBlank
    @Schema(description = "재발급에 사용할 Refresh Token")
    String refreshToken
) {
}
