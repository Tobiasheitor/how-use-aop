package com.learnAOP.howUseAOP.handler;

import org.springframework.http.HttpStatus;

public class TaskException extends RuntimeException {

    private String message;
    private HttpStatus httpStatus;

    public TaskException(String message) {
        super();
        this.message = message;
    }

    public TaskException(String message, HttpStatus httpStatus) {
        super();
        this.message = message;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
