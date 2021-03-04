package com.siit.nationalgrupa3.hr.employee.controller;

import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDto;
import com.siit.nationalgrupa3.hr.employee.service.EmployeeService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.RequiredArgsConstructor;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeRestController {

//    @Autowired
    private final EmployeeService employeeService;

//    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<EmployeeEntity> getEmployeeById(Integer id){
//        return ResponseEntity.ok(new EmployeeEntity());
//    }

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto getEmployeeById(@PathVariable(name = "employeeId") Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> getAllEmployeesByJob(@RequestParam(name = "job") String job){
        return employeeService.getAllEmployeesByJob(job);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
