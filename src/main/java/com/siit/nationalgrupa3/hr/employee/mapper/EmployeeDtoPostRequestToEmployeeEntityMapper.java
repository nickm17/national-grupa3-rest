package com.siit.nationalgrupa3.hr.employee.mapper;

import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoCreateRequest;
import com.siit.nationalgrupa3.hr.employee.exception.DepartmentNotFoundException;
import com.siit.nationalgrupa3.hr.employee.repository.DepartmentRepository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmployeeDtoPostRequestToEmployeeEntityMapper {

    private final DepartmentRepository departmentRepository;

    public EmployeeEntity mapDtoPostRequestToEntity(EmployeeDtoCreateRequest dto) {
        return EmployeeEntity.builder()
                             .hiredate(dto.getHiredate())
                             .comision(dto.getComision())
                             .job(dto.getJob())
                             .manager(dto.getManager())
                             .name(dto.getName())
                             .salary(dto.getSalary())
                             .department(departmentRepository.findById(dto.getDepartmentId()).orElseThrow(() -> new DepartmentNotFoundException("no dept found for given id: "+ dto.getDepartmentId())))
                             .build();
    }

}
