package com.gevernova.EmployeePayRoll.exceptions;


public class IDNotFound extends RuntimeException{
    public IDNotFound(String message){
        super(message);
    }
}