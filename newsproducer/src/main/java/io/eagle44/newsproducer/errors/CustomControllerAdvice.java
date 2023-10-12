package io.eagle44.newsproducer.errors;

import io.eagle44.newsproducer.exceptions.ServiceUnavailableException;
import io.eagle44.newsproducer.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse> handleUnauthorizedExceptions(Exception e) {
        HttpStatus status = HttpStatus.UNAUTHORIZED; // 401
        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
    }

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<ErrorResponse> handleServiceUnavailableExceptions(Exception e) {
        HttpStatus status = HttpStatus.SERVICE_UNAVAILABLE; // 503
        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
    }

    // fallback method
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        return new ResponseEntity<>(new ErrorResponse(status, e.getMessage()), status);
    }
}
