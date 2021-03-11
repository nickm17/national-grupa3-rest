package com.siit.nationalgrupa3.hr.employee.mapper;

import com.siit.nationalgrupa3.hr.employee.domain.entity.DepartmentEntity;
import com.siit.nationalgrupa3.hr.employee.domain.model.DepartmentDto;

import org.springframework.stereotype.Component;

@Component
public class DepartmentEntityToDepartmentDtoMapper {

    public DepartmentDto mapEntityToDto(DepartmentEntity entity) {
        if (entity == null){
            return null;
        }
        return DepartmentDto.builder()
                            .city(entity.getCity())
                            .name(entity.getName())
                            .createdAt(entity.getCreatedAt())
                            .id(entity.getId())
                            .modifiedAt(entity.getModifiedAt())
                            .build();

    }

}
