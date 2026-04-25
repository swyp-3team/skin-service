package com.swyp3.skin.domain.routine.exception;

import com.swyp3.skin.global.exception.CustomException;
import com.swyp3.skin.global.exception.ErrorCode;

public class RoutineException extends CustomException {
    public RoutineException(ErrorCode errorCode) {
        super(errorCode);
    }
}
