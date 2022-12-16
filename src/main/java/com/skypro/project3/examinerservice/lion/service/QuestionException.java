package com.skypro.project3.examinerservice.lion.service;

public class QuestionException extends Throwable {
    public QuestionException() {
    }

    public QuestionException(String message) {
        super(message);
    }

    public QuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionException(Throwable cause) {
        super(cause);
    }

    public QuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
