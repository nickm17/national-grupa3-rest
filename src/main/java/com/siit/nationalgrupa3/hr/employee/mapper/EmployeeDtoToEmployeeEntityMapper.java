package com.siit.nationalgrupa3.hr.employee.mapper;

import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoResponse;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDtoToEmployeeEntityMapper {

    public EmployeeEntity mapDtoToEntity(EmployeeDtoResponse dto) {
        return EmployeeEntity.builder()
//                          .id(dto.getId())
                             .hiredate(dto.getHiredate())
                             .comision(dto.getComision())
                             .job(dto.getJob())
                             .manager(dto.getManager())
                             .name(dto.getName())
                             .salary(dto.getSalary())
                             .build();
    }

}
