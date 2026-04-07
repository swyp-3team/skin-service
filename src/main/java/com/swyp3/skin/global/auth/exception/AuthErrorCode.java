package com.swyp3.skin.global.auth.exception;

import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    INVALID_PROVIDER(HttpStatus.BAD_REQUEST, "AUTH_400_001", "지원하지 않는 소셜 로그인입니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
