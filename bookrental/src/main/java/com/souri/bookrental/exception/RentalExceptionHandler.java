package com.souri.bookrental.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.net.ConnectException;

@RestControllerAdvice
public class RentalExceptionHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Object> handleNotFoundException(HttpClientErrorException.NotFound e) {
        String errorMessage = "Given entity cannot be processed: JSON parse error";
        return buildErrorResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage));
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity<Object> handleBadRequestException(HttpClientErrorException.BadRequest e) {
        String errorMessage = "Given entity cannot be processed: JSON parse error";
        return buildErrorResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, errorMessage));
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerErrorException(HttpServerErrorException.InternalServerError e) {
        String errorMessage = "Given entity cannot be processed: JSON parse error";
        return buildErrorResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage));
    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConnectException(ConnectException e) {
        String errorMessage = "Given entity cannot be processed: JSON parse error";
        return buildErrorResponseEntity(new ApiError(HttpStatus.GATEWAY_TIMEOUT, errorMessage));
    }

    ResponseEntity<Object> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
