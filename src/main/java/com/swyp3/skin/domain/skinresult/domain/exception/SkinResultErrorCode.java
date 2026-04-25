package com.swyp3.skin.domain.skinresult.domain.exception;

import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SkinResultErrorCode implements ErrorCode {

    SKIN_RESULT_NOT_FOUND(HttpStatus.NOT_FOUND,"SKIN_RESULT_404_001", "진단결과를 찾을 수 없습니다."),
    SKIN_RESULT_NOT_YET(HttpStatus.NOT_FOUND,"SKIN_RESULT_404_001", "피부 진단을 아직 수행하지 않았습니다.");



    private final HttpStatus status;
    private final String code;
    private final String message;
}
