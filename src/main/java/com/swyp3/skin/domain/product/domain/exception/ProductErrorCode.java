package com.swyp3.skin.domain.product.domain.exception;

import com.swyp3.skin.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ProductErrorCode implements ErrorCode {

    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND,"PRODUCT_ERROR_404_001", "상품을 찾을 수 없습니다."),
    INVALID_KEYWORD(HttpStatus.BAD_REQUEST,"PRODUCT_ERROR_400_001","키워드는 비어있을수 없습니다." );

    private final HttpStatus status;
    private final String code;
    private final String message;
}
