package com.smilegzc.spring_account.controller;

import com.smilegzc.spring_account.exception.AccountException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 日期:2020/3/30
 * 时间:上午12:46
 */
@ControllerAdvice
public class AccountExceptionController {
    @ExceptionHandler(AccountException.class)
    public String accountException(Exception e, HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 403);
        return "forward:/error";
    }
}
