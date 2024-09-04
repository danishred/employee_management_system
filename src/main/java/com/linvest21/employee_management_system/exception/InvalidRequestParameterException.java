package com.linvest21.employee_management_system.exception;

// When resource is not found, used in GlobalExceptionHandler
public class InvalidRequestParameterException extends RuntimeException {
    public InvalidRequestParameterException(String message) {
        super(message);
    }
}