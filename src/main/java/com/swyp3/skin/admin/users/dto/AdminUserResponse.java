package com.swyp3.skin.admin.users.dto;

import com.swyp3.skin.domain.user.domain.enums.UserStatus;
import com.swyp3.skin.global.auth.enums.AuthProvider;

import java.time.LocalDateTime;

public record AdminUserResponse(
        Long userId,
        String nickname,
        String email,
        AuthProvider provider,
        LocalDateTime createdAt,
        LocalDateTime lastLoginAt,
        Long totalDiagnoses,
        LocalDateTime lastDiagnosedAt,
        Boolean diagnosed,
        Boolean reDiagnosed,
        UserStatus status
) {
}
