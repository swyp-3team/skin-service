package com.swyp3.skin.global.auth.enums;

import com.swyp3.skin.global.auth.exception.AuthErrorCode;
import com.swyp3.skin.global.auth.exception.AuthException;
import lombok.Getter;


@Getter
public enum AuthProvider {
    GOOGLE, KAKAO;



    // provider 받아서 어퍼케이스 반환
    // null,혹은 지원하지 않는값 들어올시 400
    public static AuthProvider from(String provider) {
        if (provider == null || provider.isBlank()) {
            throw new AuthException(AuthErrorCode.INVALID_PROVIDER);
        }

        return switch (provider.toLowerCase()) {
            case "google" -> GOOGLE;
            case "kakao" -> KAKAO;
            default -> throw new AuthException(AuthErrorCode.INVALID_PROVIDER);
        };
    }
}
