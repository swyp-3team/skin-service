package com.swyp3.skin.domain.skinttest.exception;

import com.swyp3.skin.global.exception.CustomException;
import com.swyp3.skin.global.exception.ErrorCode;

public class SkinTestException extends CustomException {
    public SkinTestException(ErrorCode errorCode) {super(errorCode);}
}
