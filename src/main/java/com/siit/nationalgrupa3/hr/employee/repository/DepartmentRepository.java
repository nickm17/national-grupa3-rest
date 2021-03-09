package com.siit.nationalgrupa3.hr.employee.repository;

import com.siit.nationalgrupa3.hr.employee.domain.entity.DepartmentEntity;
import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
