package com.groceryservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author vipul.singh
 */
@ControllerAdvice
public class ErrorHandlingControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomExceptions.class)
    public ResponseEntity<String> handleCustomTimeConversionException(CustomExceptions ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

