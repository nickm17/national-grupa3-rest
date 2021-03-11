package com.siit.nationalgrupa3.hr.employee.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String msg){
        super(msg);
    }
}
