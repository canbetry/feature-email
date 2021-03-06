package com.feature.email.common.response;

import com.feature.email.common.Enum.Constant;
import com.feature.email.common.inteface.BaseBussinessStatus;

import java.io.Serializable;

/**
 * 统一响应类
 *
 * @description: ResponseEntity <br>
 * @date: 2020/1/7 11:09 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
 */
public class ResponseEntity<T> implements Serializable {

    public static final ResponseEntity SUCCEED = new ResponseEntity(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE);
    public static final ResponseEntity Failed = new ResponseEntity(Constant.ERROR_CODE, Constant.ERROR_MESSAGE);

    private int status;
    private T content;
    private String message;

    public ResponseEntity(int status) {
        this.status = status;
    }

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

    public static ResponseEntity responseBySucceed() {
        return new ResponseEntity(Constant.SUCCESS_CODE);
    }

    public static ResponseEntity responseBySucceed(String message) {
        return new ResponseEntity(Constant.SUCCESS_CODE, message);
    }

    public static <T> ResponseEntity<T> responseBySucceed(T content) {
        return new ResponseEntity(Constant.SUCCESS_CODE, content);
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
