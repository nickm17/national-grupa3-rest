package com.siit.nationalgrupa3.hr.employee.controller;

import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoResponse;
import com.siit.nationalgrupa3.hr.employee.service.EmployeeService;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeRestController employeeRestController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void cel_mai_simplu_test(){

        EmployeeDtoResponse employeeDtoResponse = EmployeeDtoResponse.builder().build();
        Mockito.when(employeeService.getEmployeeById(123)).thenReturn(employeeDtoResponse);

        EmployeeDtoResponse employeeById = employeeRestController.getEmployeeById(123);

        Assertions.assertThat(employeeById).isSameAs(employeeDtoResponse);
    }

}
