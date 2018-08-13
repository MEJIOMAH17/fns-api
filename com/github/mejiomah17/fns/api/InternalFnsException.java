package com.github.mejiomah17.fns.api;

public class InternalFnsException extends Exception {
    public InternalFnsException() {
    }

    public InternalFnsException(String message) {
        super(message);
    }

    public InternalFnsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalFnsException(Throwable cause) {
        super(cause);
    }

    public InternalFnsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
