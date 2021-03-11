package com.siit.nationalgrupa3.hr.employee.controller;

import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoResponse;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoCreateRequest;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoUpdateRequest;
import com.siit.nationalgrupa3.hr.employee.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static java.time.LocalDateTime.now;

//@Controller
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employees")
public class EmployeeRestController {

//    @Autowired
    private final EmployeeService employeeService;

//    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<EmployeeEntity> getEmployeeById(Integer id){
//        return ResponseEntity.ok(new EmployeeEntity());
//    }

    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDtoResponse getEmployeeById(@PathVariable(name = "employeeId") Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping(value = "/query", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDtoResponse> getAllEmployeesByJob(@RequestParam(name = "job") String job){
        return employeeService.getAllEmployeesByJob(job);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDtoResponse> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/another-get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDtoResponse> getAllEmployees2(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDtoResponse createEmployee(@RequestBody @Valid EmployeeDtoCreateRequest employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDtoResponse updateEmployee(@PathVariable(name = "id") Integer employeeId,
                                              @RequestBody @Valid EmployeeDtoUpdateRequest employeeDto){
        employeeDto.setId(employeeId);
        return employeeService.updateEmployee(employeeDto);
    }

    @PostMapping("/bulk")
    public List<EmployeeDtoResponse> createEmployees(@RequestBody @Valid List<EmployeeDtoCreateRequest> employeeDtos){
        return employeeService.createEmployees(employeeDtos);
    }

    @PostMapping("/csv-upload")
    public List<EmployeeDtoResponse> createEmployees(@RequestParam(name = "csv-file") MultipartFile file){
        return employeeService.createEmployeesFromFile(file);
    }

    @DeleteMapping(value = "/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable(name = "employeeId") Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }
}
