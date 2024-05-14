package com.emp.employeemanagement.api.exception;

import java.io.Serial;

public class DepartmentNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -4886750832331458988L;
    public DepartmentNotFoundException(String message){
        super(message);
    }
}
