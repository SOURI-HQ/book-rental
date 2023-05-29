package com.souri.bookservice.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("Book of given ID was not found");
    }
    public BookNotFoundException(String message) {
        super(message);
    }
    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
