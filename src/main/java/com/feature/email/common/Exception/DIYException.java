package com.feature.email.common.Exception;


/**
 * 自定义异常类
 */
public class DIYException extends RuntimeException {
    public DIYException() {
        super();
    }

    public DIYException(String message) {
        super(message);
    }

    public DIYException(String message, Throwable cause) {
        super(message, cause);
    }

    public DIYException(Throwable cause) {
        super(cause);
    }
}
