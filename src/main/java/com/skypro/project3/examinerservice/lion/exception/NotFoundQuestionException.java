package com.skypro.project3.examinerservice.lion.exception;

public class NotFoundQuestionException extends RuntimeException {
    public NotFoundQuestionException() {
    }

    public NotFoundQuestionException(String message) {
        super(message);
    }

    public NotFoundQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundQuestionException(Throwable cause) {
        super(cause);
    }

    public NotFoundQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
