package com.david.spring.error.spring_error.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.david.spring.error.spring_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<?> divisionByZero(Exception ex) {

        return ResponseEntity.internalServerError().body("error 500");
    }

}
