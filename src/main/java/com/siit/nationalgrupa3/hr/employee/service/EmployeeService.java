package com.siit.nationalgrupa3.hr.employee.service;

import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeEntityToEmployeeDtoMapper;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDto;
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

    private final EmployeeEntityToEmployeeDtoMapper employeeEntityToEmployeeDtoMapper;

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
}
