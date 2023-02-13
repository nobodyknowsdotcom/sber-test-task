package com.example.sbertesttask.controller.exceptionhandler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<String> failedValidationException(ConstraintViolationException constraintViolationException) {
        String exceptionCause = constraintViolationException.getConstraintViolations().toString();

        log.warn(String.format("Caught validation with root cause %s", exceptionCause));
        return new ResponseEntity<>(exceptionCause, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<String> failedEnumParsingException(IllegalArgumentException illegalArgumentException) {
        String exceptionCause = illegalArgumentException.getMessage();

        log.warn(String.format("Caught IllegalArgumentException with root cause %s", exceptionCause));
        return new ResponseEntity<>(exceptionCause, HttpStatus.BAD_REQUEST);
    }
}
