package com.feature.email.common.Response;

import com.feature.email.common.Enum.Constant;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 自定义返回响应类
 */
public class ResponseEntity<T> extends HashMap<String, Object> implements Serializable {

    public static final ResponseEntity SUCCEED = new ResponseEntity(Constant.SUCCESS_CODE, Constant.SUCCESS_MESSAGE);
    public static final ResponseEntity Failed = new ResponseEntity(Constant.ERROR_CODE, Constant.ERROR_MESSAGE);

    public ResponseEntity(int status, String massage) {
        super();
        this.put(Constant.STATUS, status).put(Constant.STATUS, massage);
    }

    public ResponseEntity(int status, T content) {
        super();
        this.put(Constant.STATUS, status).put(Constant.CONTENT, content);
    }

    public ResponseEntity(int status, String message, T content) {
        super();
        this.put(Constant.STATUS, status).put(Constant.MESSAGE, message).put(Constant.CONTENT, content);
    }


    public ResponseEntity put(String key, Object value) {
        super.put(key, value);
        return this;
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

    public boolean isNotSuccess(ResponseEntity<T> responseEntity) {
        return (Constant.SUCCESS_CODE != (Integer) responseEntity.get(Constant.STATUS));
    }

}
