package com.swyp3.skin.global.auth.exception;

import com.swyp3.skin.global.exception.CustomException;

public class AuthException extends CustomException {
    public AuthException(AuthErrorCode errorCode) {
        super(errorCode);
    }
}
