package com.siit.nationalgrupa3.hr.employee.mapper;

import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoResponse;
import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeEntityToEmployeeDtoMapper {

    private final DepartmentEntityToDepartmentDtoMapper departmentEntityToDepartmentDtoMapper;

    public EmployeeDtoResponse mapEntityToDto(EmployeeEntity entity) {
        return EmployeeDtoResponse.builder()
                                  .id(entity.getId())
                                  .hiredate(entity.getHiredate())
                                  .comision(entity.getComision())
                                  .job(entity.getJob())
                                  .manager(entity.getManager())
                                  .name(entity.getName())
                                  .salary(entity.getSalary())
                                  .department(departmentEntityToDepartmentDtoMapper.mapEntityToDto(entity.getDepartment()))
                                  .build();

    }

}
