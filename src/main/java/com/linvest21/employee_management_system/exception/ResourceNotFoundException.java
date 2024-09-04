package com.linvest21.employee_management_system.exception;

// When request parameter is invalid, used in GlobalExceptionHandler
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}