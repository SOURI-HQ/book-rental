package com.souri.bookservice.exception;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException() {
        super("Given entity cannot be processed");
    }
    public UnprocessableEntityException(String message) {
        super(message);
    }
    public UnprocessableEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
