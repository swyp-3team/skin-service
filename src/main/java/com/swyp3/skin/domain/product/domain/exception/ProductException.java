package com.swyp3.skin.domain.product.domain.exception;

import com.swyp3.skin.global.exception.CustomException;
import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class ProductException extends CustomException {
    public ProductException(ErrorCode errorCode) {super(errorCode);}
}
