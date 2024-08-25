package com.FalakSolution.Trainig.controoler;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionErrorController {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> handleBindException(BindException ex){
        List<ObjectError> errorMessages = ex.getAllErrors();
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
}
