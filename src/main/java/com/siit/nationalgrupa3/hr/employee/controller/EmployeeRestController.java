package com.siit.nationalgrupa3.hr.employee.controller;

import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDto;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoPostRequest;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoUpdateRequest;
import com.siit.nationalgrupa3.hr.employee.service.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.ValidationException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

    @GetMapping(path = "/another-get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> getAllEmployees2(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto createEmployee(@RequestBody @Valid EmployeeDtoPostRequest employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @PutMapping(value = "/{id}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDto updateEmployee(@PathVariable(name = "id") Integer employeeId,
                                      @RequestBody @Valid EmployeeDtoUpdateRequest employeeDto){
        employeeDto.setId(employeeId);
        return employeeService.updateEmployee(employeeDto);
    }

    @ExceptionHandler({ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> badRequest(HttpServletResponse response, Exception ex, BindingResult bindingResult) throws IOException {
        log.error(ex.getMessage(), ex);
        return ResponseEntity.badRequest().body(createErrorResponseForPathAndBodyValidationExceptions(ex, bindingResult));
    }

    private ErrorResponse createErrorResponseForPathAndBodyValidationExceptions(Exception e, BindingResult bindingResult) {
        var errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return errorResponse;
    }

}
