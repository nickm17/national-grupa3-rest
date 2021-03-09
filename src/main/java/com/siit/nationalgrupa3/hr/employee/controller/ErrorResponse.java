package com.siit.nationalgrupa3.hr.employee.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private int status;

    private String errorMsg;
}
