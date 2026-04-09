package com.swyp3.skin.domain.skinttest.exception;

import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SkinTestErrorCode implements ErrorCode {
    INVALID_SURVEY_STEP(HttpStatus.BAD_REQUEST, "SKIN_TEST_400_001", "유효하지 않은 설문 단계입니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
