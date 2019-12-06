package com.feature.email.common.Response;

import com.feature.email.common.Enum.Constant;
import com.feature.email.common.inteface.BaseBussinessStatus;

import java.io.Serializable;

/**
 * 自定义返回响应类
 */
public class ResponseEntity<T> implements Serializable {

    public static final ResponseEntity SUCCEED = new ResponseEntity(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE);
    public static final ResponseEntity Failed = new ResponseEntity(Constant.ERROR_CODE, Constant.ERROR_MESSAGE);

    private int status;
    private T content;
    private String message;

    public ResponseEntity(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseEntity(int status, T content) {
        this.status = status;
        this.content = content;
    }

    public ResponseEntity(int status, String message, T content) {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public int getStatus() {
        return this.status;
    }

    public T getContent() {
        return this.content;
    }

    public String getMessage() {
        return this.message;
    }

    public static ResponseEntity response(int i, String message) {
        return new ResponseEntity(i, message);
    }

    public static ResponseEntity responseBySucceed(String message) {
        return new ResponseEntity(Constant.SUCCESS_CODE, message);
    }

    public static ResponseEntity responseByFailed(String message) {
        return new ResponseEntity(Constant.ERROR_CODE, message);
    }

    public static <T> ResponseEntity<T> responseBySucceedContent(String message, T content) {
        return new ResponseEntity<T>(Constant.SUCCESS_CODE, message, content);
    }

    public static <T> ResponseEntity<T> responseByErrorContent(String message, T content) {
        return new ResponseEntity<T>(Constant.ERROR_CODE, message, content);
    }

    public static <T> ResponseEntity<T> responseBySucceedContent(T content) {
        return new ResponseEntity<T>(Constant.SUCCESS_CODE, content);
    }

    public static <T> ResponseEntity<T> responseByErrorMessage(String message) {
        return new ResponseEntity<T>(Constant.ERROR_CODE, message);
    }

    public static <T> ResponseEntity<T> responseBySucceedMessage(String message) {
        return new ResponseEntity<T>(Constant.SUCCESS_CODE, message);
    }

    public boolean isNotSuccess() {
        return this.status != 200;
    }

    public boolean isSuccess() {
        return !isNotSuccess();
    }

    public static <T> ResponseEntity<T> errorInfo(BaseBussinessStatus baseBussinessStatus) {
        return new ResponseEntity<>(baseBussinessStatus.getCode(), baseBussinessStatus.getMessage());
    }

}
