package com.emp.employeemanagement.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 6882678956583151215L;

    public EmployeeNotFoundException(String message){
        super(message);
    }
}
