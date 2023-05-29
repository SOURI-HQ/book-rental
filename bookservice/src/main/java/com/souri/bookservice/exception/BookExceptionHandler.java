package com.souri.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    protected ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException e) {
        return buildErrorResponseEntity(new ApiError(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    protected ResponseEntity<Object> handleUnprocessableEntityException(UnprocessableEntityException e) {
        return buildErrorResponseEntity(new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<Object> handleHttpMessageNotReadableException() {
        String errorMessage = "Given entity cannot be processed: JSON parse error";
        return buildErrorResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage));
    }

    private ResponseEntity<Object> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
