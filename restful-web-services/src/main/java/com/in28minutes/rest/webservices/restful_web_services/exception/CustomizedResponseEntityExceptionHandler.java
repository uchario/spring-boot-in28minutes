package com.in28minutes.rest.webservices.restful_web_services.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(), ex.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
