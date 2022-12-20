package com.skypro.project3.examinerservice.lion.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handlerBadRequestException(RuntimeException e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundQuestionException.class)
    public ResponseEntity<Object> handlerNotFoundQuestionException(RuntimeException e, WebRequest request) {
        return new ResponseEntity<>(e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
