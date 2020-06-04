package com.luyuze.missyou.core;

import com.luyuze.missyou.exception.http.HttpException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        return new UnifyResponse(9999, "server error", "url");
    }

    @ExceptionHandler(HttpException.class)
    public void handleHttpException(HttpServletRequest request, HttpException e) {
        System.out.println("HttpException");
    }
}
