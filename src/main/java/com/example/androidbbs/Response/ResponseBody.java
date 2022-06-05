package com.example.androidbbs.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ResponseBody<T> extends ResponseEntity<Response<T>> {

    public ResponseBody(HttpStatus status) {
        super(status);
    }

    //返回体 初始化
    public ResponseBody(String code, String msg, T data) {
        super(Response.response(code, msg, data), Response.numToHttpStatus(code));
    }

    //返回体 初始化
    public ResponseBody(String code, String msg) {
        super(Response.response(code, msg), Response.numToHttpStatus(code));
    }

    //返回 200
    public static <T> ResponseBody<T> success(T data) {
        return new ResponseBody<>("200", "成功", data);
    }

    //返回 失败
    public static <T> ResponseBody<T> failed(T data) {
        return new ResponseBody<>("422", "失败", data);
    }

    //返回 自定义失败
    public static <T> ResponseBody<T> failMsg(String msg) {
        return new ResponseBody<>("422", msg);
    }

    //返回 自定义返回
    public static <T> ResponseBody<T> responseBody(String code, String msg, T data) {
        return new ResponseBody<>(code, msg, data);
    }
}

class Response<T>{
    String status;
    String msg;
    T result;

    public Response(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Response(String status, String msg, T result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public static <T> Response<T> response(String status, String message, T data) {
        return new Response<>(status, message, data);
    }

    public static <T> Response<T> response(String status, String message) {
        return new Response<>(status, message);
    }

    //将数字转化成状态码
    public static HttpStatus numToHttpStatus(String code) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        for (HttpStatus httpStatus : HttpStatus.values()) {
            boolean b = Integer.parseInt(code) == httpStatus.value();
            if (b) {
                return httpStatus;
            }
        }
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
