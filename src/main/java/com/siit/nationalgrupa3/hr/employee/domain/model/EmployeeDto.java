package com.siit.nationalgrupa3.hr.employee.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Integer id;

    private String job;

    private String name;

    private Integer manager;

    private Integer salary;

    private Integer comision;

//    private DepartmentEntity department;

    @Builder.Default
    private LocalDate hiredate = LocalDate.now();

}
