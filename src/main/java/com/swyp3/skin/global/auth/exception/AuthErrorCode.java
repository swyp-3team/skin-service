package com.swyp3.skin.global.auth.exception;

import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum AuthErrorCode implements ErrorCode {

    INVALID_PROVIDER(HttpStatus.BAD_REQUEST, "AUTH_400_001", "지원하지 않는 소셜 로그인입니다"),
    INVALID_OAUTH_USER_INFO(HttpStatus.BAD_REQUEST, "AUTH_400_002", "소셜 로그인 사용자 정보가 유효하지 않습니다"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "AUTH_404_001", "사용자를 찾을 수 없습니다"),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_401_001", "유효하지 않은 토큰입니다"),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "AUTH_401_002", "만료된 토큰입니다");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
