package com.swyp3.skin.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public String handleCustom(CustomException e, Model model) {

        log.warn("Business Exception 발생 : errorCode = {} | message = {}",
                e.getErrorCode(),
                e.getMessage());

        model.addAttribute("errorMessage", e.getErrorCode().getMessage());
        return "error/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        log.error("Unexpected Exception 발생", e);

        model.addAttribute("errorMessage", "서버 내부 오류가 발생했습니다");
        return "error/error";
    }
}
