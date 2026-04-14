package com.swyp3.skin.domain.skinttest.exception;

import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SkinTestErrorCode implements ErrorCode {
    INVALID_SURVEY_STEP(HttpStatus.BAD_REQUEST, "SKIN_TEST_400_001", "유효하지 않은 설문 단계입니다."),
    INVALID_SURVEY_ANSWER_PAYLOAD(HttpStatus.BAD_REQUEST, "SKIN_TEST_400_002", "설문 응답 형식이 올바르지 않습니다."),
    PREVIEW_TOKEN_EXPIRED(HttpStatus.BAD_REQUEST, "SKIN_TEST_400_003", "미리보기 토큰이 만료되었거나 존재하지 않습니다."),
    INVALID_PREVIEW_TOKEN_OWNER(HttpStatus.FORBIDDEN, "SKIN_TEST_403_001", "해당 미리보기 토큰에 접근할 권한이 없습니다.");


    private final HttpStatus status;
    private final String code;
    private final String message;
}
