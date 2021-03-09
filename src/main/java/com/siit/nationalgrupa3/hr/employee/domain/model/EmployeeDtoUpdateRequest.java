package com.siit.nationalgrupa3.hr.employee.domain.model;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDtoUpdateRequest {

    private String job;

    private Integer id;

    @NotBlank
    private String name;

    @Min(10)
    @Max(value = 9000, message = "manager id must be lower than or equal to 9000")
    private Integer manager;

    private Integer salary;

    @NotNull(message = "Comision must be provided for update")
    @Max(100)
    @Min(10)
    private Integer comision;
}
