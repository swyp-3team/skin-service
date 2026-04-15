package com.swyp3.skin.domain.skinresult.domain.exception;

import com.swyp3.skin.global.exception.CustomException;
import com.swyp3.skin.global.exception.ErrorCode;

public class SkinResultException extends CustomException {
    public SkinResultException(ErrorCode errorCode) {super(errorCode);}
}
