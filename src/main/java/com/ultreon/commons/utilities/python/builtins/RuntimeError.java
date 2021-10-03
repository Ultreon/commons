package com.ultreon.commons.utilities.python.builtins;

public class RuntimeError extends RuntimeException {
    public RuntimeError() {
    }

    public RuntimeError(String message) {
        super(message);
    }

    public RuntimeError(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeError(Throwable cause) {
        super(cause);
    }

    public RuntimeError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
