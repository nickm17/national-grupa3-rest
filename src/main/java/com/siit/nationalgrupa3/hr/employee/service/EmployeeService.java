package com.siit.nationalgrupa3.hr.employee.service;

import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoPostRequest;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoUpdateRequest;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeDtoPostRequestToEmployeeEntityMapper;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeDtoToEmployeeEntityMapper;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeEntityToEmployeeDtoMapper;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDto;
import com.siit.nationalgrupa3.hr.employee.repository.DepartmentRepository;
import com.siit.nationalgrupa3.hr.employee.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;

import static java.util.stream.Collectors.toList;


//@Data
@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class EmployeeService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeEntityToEmployeeDtoMapper employeeEntityToEmployeeDtoMapper;
    private final EmployeeDtoToEmployeeEntityMapper employeeDtoToEmployeeEntityMapper;
    private final EmployeeDtoPostRequestToEmployeeEntityMapper employeeDtoPostRequestToEmployeeEntityMapper;

    //    @Autowired - folosit pentru field injection
    private final EmployeeRepository employeeRepository;

    private int counter;

//    @Autowired
//    public EmployeeService(EmployeeRepository employeeRepositoryDinContext){
//        employeeRepository = employeeRepositoryDinContext;
//    }

//    public EmployeeService(EmployeeRepository employeeRepositoryDinContext, int i){
//        employeeRepository = employeeRepositoryDinContext;
//        counter = i;
//    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll()
                                 .stream()
                                 .map(empEnt -> employeeEntityToEmployeeDtoMapper.mapEntityToDto(empEnt))
                                 .collect(toList());
    }

    public List<EmployeeDto> getAllEmployeesByJob(String job) {
        return employeeRepository.findAllByJob(job)
                                 .stream()
                                 .map(empEnt -> employeeEntityToEmployeeDtoMapper.mapEntityToDto(empEnt))
                                 .collect(toList());
    }

    public EmployeeDto getEmployeeById(Integer id) {
        return employeeEntityToEmployeeDtoMapper.mapEntityToDto(employeeRepository.findById(id).orElseThrow());
    }

    public EmployeeDto createEmployee(EmployeeDtoPostRequest employeeDtoPostRequest) {

        EmployeeEntity employeeEntity = employeeDtoPostRequestToEmployeeEntityMapper.mapDtoPostRequestToEntity(employeeDtoPostRequest);
//        employeeEntity.setDepartment(departmentRepository.findById(employeeDtoPostRequest.getDepartmentId()).orElseThrow());

        // alte actiuni pe entity
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);

        return employeeEntityToEmployeeDtoMapper.mapEntityToDto(savedEntity);
    }

    public EmployeeDto updateEmployee(EmployeeDtoUpdateRequest employeeDtoUpdateRequest) {

        EmployeeEntity employeeEntity = employeeRepository.findById(employeeDtoUpdateRequest.getId()).get();
        // setam campurile ce vrem sa fie updatate
        if (employeeDtoUpdateRequest.getComision() != null){ // facem update doar daca exista
            employeeEntity.setComision(employeeDtoUpdateRequest.getComision());
        }
        employeeEntity.setJob(employeeDtoUpdateRequest.getJob());
        employeeEntity.setName(employeeDtoUpdateRequest.getName());
        employeeEntity.setManager(employeeDtoUpdateRequest.getManager());


        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);

        return employeeEntityToEmployeeDtoMapper.mapEntityToDto(savedEntity);
    }

}
