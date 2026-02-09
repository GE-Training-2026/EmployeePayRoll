package com.gevernova.EmployeePayRoll.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IDNotFound.class)
    public ResponseEntity<String> throwError(IDNotFound idNotFound){
        return new ResponseEntity<>("id not found ",HttpStatus.NOT_FOUND);
    }
}