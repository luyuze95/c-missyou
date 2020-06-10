package com.luyuze.missyou.core;

import com.luyuze.missyou.core.configuration.ExceptionCodeConfiguration;
import com.luyuze.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest request, Exception e) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        return new UnifyResponse(9999, "server error", method + " " + requestUrl);
    }

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest request, HttpException e) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        UnifyResponse message = new UnifyResponse(
                e.getCode(), "待完善的错误信息", method + " " + requestUrl);
        // codeConfiguration.getMessage(e.getCode())
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(message, headers, httpStatus);
        return r;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidation(HttpServletRequest request,
                                              MethodArgumentNotValidException e) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String messages = formatAllErrorMessages(errors);
        return new UnifyResponse(10001, messages, method + " " + requestUrl);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintException(HttpServletRequest request,
                                                   ConstraintViolationException e) {
        String requestUrl = request.getRequestURI();
        String method = request.getMethod();
        String message = e.getMessage();

        return new UnifyResponse(10001, message, method + " " + requestUrl);
    }

    private String formatAllErrorMessages(List<ObjectError> errors) {
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append(";"));
        return errorMsg.toString();
    }
}
