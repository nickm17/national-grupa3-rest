package com.siit.nationalgrupa3.hr.employee.domain.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoPostRequest {

    private String job;

    private Integer id;

    @NotBlank
    private String name;

    private Integer manager;

    private Integer salary;

    private Integer comision;

    private Integer departmentId;

    @Builder.Default
    private LocalDate hiredate = LocalDate.now();

}
