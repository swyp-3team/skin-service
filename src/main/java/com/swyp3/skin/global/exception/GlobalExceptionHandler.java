package com.swyp3.skin.global.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public String handle(CustomException e, Model model) {
        model.addAttribute("errorMessage", e.getErrorCode().getMessage());
        return "error/error";
    }
}
