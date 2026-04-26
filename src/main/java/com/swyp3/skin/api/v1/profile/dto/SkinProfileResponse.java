package com.swyp3.skin.api.v1.profile.dto;

import com.swyp3.skin.recommendation.ux.SkinUxProfile;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record SkinProfileResponse(

        @Schema(description = "진단 시각", example = "2026.04.22")
        String diagnosedAt,

        @Schema(description = "피부 유형명")
        String skinType,

        @Schema(description = "부제")
        String subtitle,

        @Schema(description = "피부 설명")
        String summary
)
{
    public static SkinProfileResponse from(LocalDateTime diagnosedAt, SkinUxProfile profile) {
        String formatted = diagnosedAt
                .toLocalDate()
                .format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        return new SkinProfileResponse(
                formatted,
                profile.skinType(),
                profile.subtitle(),
                profile.summary()
        );
    }
}
