package com.feature.email.common.Exception;


/**
 * @description: DIYException <br>
 * @date: 2020/1/7 11:11 <br>
 * @author: luoyl <br>
 * @version: 1.0 <br>
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
