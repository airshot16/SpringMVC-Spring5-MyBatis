package com.spring.entity;

/**
 * ajax 请求返回实体类
 */
public class HttpResultEntity {
    private Code code;
    private String message;
    private String data;

    public HttpResultEntity(Code code, String message, String data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public enum Code {
        Success, Error, ParameterException
    }
}
