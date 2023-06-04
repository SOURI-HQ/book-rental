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

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<Object> handleInternalServerErrorException(HttpServerErrorException.InternalServerError e) {
        String errorMessage = "Bookservice: Internal Server Error";
        return buildErrorResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage));
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ResponseEntity<Object> handleNotFoundException(HttpClientErrorException.NotFound e) {
        String errorMessage = "Requested endpoint or item does not exist";
        return buildErrorResponseEntity(new ApiError(HttpStatus.NOT_FOUND, errorMessage));
    }

//    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
//    public ResponseEntity<Object> handleBadRequestException(HttpClientErrorException.BadRequest e) {
//        String errorMessage = "BadRequest - rental";
//        return buildErrorResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, e.getResponseBodyAsString()));
//    }

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConnectException(ConnectException e) {
        String errorMessage = "ConnectException - rental";
        return buildErrorResponseEntity(new ApiError(HttpStatus.GATEWAY_TIMEOUT, errorMessage));
    }

    ResponseEntity<Object> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
