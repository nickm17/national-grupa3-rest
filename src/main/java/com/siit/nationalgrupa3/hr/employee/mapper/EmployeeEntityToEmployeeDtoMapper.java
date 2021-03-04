package com.siit.nationalgrupa3.hr.employee.mapper;

import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDto;
import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;

import org.springframework.stereotype.Component;

@Component
public class EmployeeEntityToEmployeeDtoMapper {

    public EmployeeDto mapEntityToDto(EmployeeEntity entity) {
        return EmployeeDto.builder()
                          .id(entity.getId())
                          .hiredate(entity.getHiredate())
                          .comision(entity.getComision())
                          .job(entity.getJob())
                          .manager(entity.getManager())
                          .name(entity.getName())
                          .salary(entity.getSalary())
                          .build();

    }

}
