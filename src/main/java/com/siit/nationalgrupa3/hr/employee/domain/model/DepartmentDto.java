package com.siit.nationalgrupa3.hr.employee.domain.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DepartmentDto {

    private String city;

    private LocalDateTime createdAt;

    private Integer id;

    private LocalDateTime modifiedAt;

    private String name;
}
