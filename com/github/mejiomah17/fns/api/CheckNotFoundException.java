package com.github.mejiomah17.fns.api;

public class CheckNotFoundException extends Exception {
    public CheckNotFoundException() {
    }

    public CheckNotFoundException(String message) {
        super(message);
    }

    public CheckNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckNotFoundException(Throwable cause) {
        super(cause);
    }

    public CheckNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
