package com.david.spring.error.spring_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.david.spring.error.spring_error.Exceptions.UserNotFoundException;
import com.david.spring.error.spring_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {
    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Error Division entre 0!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        // return ResponseEntity.internalServerError().body(error);//esta o la de abajo
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

    }

    // aqui se soluciona de dos formas poner NoHandlerFoundException y agregar
    // configuraciones en el properties
    // o sustituir NoHandlerFoundException por NoResourceFoundException
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFondException(NoHandlerFoundException e) {
        Error error = new Error();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(404).body(error);

    }
    /*
     * @ExceptionHandler(NumberFormatException.class)
     * public ResponseEntity<Error> numberformat(NumberFormatException e) {
     * 
     * Error error = new Error();
     * error.setDate(new Date());
     * error.setError("No se puede trasformar el string a numero");
     * error.setMessage(e.getMessage());
     * error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
     * 
     * return
     * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
     * 
     * }
     */

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> numberFormatException(Exception e) {

        Map<String, String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("Error", "Numero incorrecto, no tiene formato de digito");
        error.put("Message", e.getMessage());
        error.put("Status", Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        return error;
    }

    @ExceptionHandler({ NullPointerException.class, HttpMessageNotWritableException.class,
            UserNotFoundException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> userNotFoundException(Exception e) {

        Map<String, String> error = new HashMap<>();
        error.put("date", new Date().toString());
        error.put("Error", "Usuario o rol no existe");
        error.put("Message", e.getMessage());
        error.put("Status", Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));

        return error;
    }

}
