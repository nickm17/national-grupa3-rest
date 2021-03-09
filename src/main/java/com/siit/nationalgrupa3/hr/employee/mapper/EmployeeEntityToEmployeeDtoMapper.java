package com.siit.nationalgrupa3.hr.employee.mapper;

import com.siit.nationalgrupa3.hr.employee.domain.model.DepartmentDto;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDto;
import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeEntityToEmployeeDtoMapper {

    private final DepartmentEntityToDepartmentDtoMapper departmentEntityToDepartmentDtoMapper;

    public EmployeeDto mapEntityToDto(EmployeeEntity entity) {
        return EmployeeDto.builder()
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
