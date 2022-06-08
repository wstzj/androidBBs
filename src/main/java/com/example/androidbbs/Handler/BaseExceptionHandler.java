package com.example.androidbbs.Handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice

public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public com.example.androidbbs.Response.ResponseBody<String> error(Exception e){
        return com.example.androidbbs.Response.ResponseBody.failed("失败");
    }
}
