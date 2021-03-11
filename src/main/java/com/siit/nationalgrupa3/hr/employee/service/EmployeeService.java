package com.siit.nationalgrupa3.hr.employee.service;

import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoCreateRequest;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoUpdateRequest;
import com.siit.nationalgrupa3.hr.employee.exception.EmployeeNotFoundException;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeDtoPostRequestToEmployeeEntityMapper;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeDtoToEmployeeEntityMapper;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeEntityToEmployeeDtoMapper;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoResponse;
import com.siit.nationalgrupa3.hr.employee.repository.DepartmentRepository;
import com.siit.nationalgrupa3.hr.employee.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

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

    @Transactional(readOnly = true)
    public List<EmployeeDtoResponse> getAllEmployees() {
        return employeeRepository.findAll()
                                 .stream()
                                 .map(empEnt -> employeeEntityToEmployeeDtoMapper.mapEntityToDto(empEnt))
                                 .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<EmployeeDtoResponse> getAllEmployeesByJob(String job) {
        return employeeRepository.findAllByJob(job)
                                 .stream()
                                 .map(empEnt -> employeeEntityToEmployeeDtoMapper.mapEntityToDto(empEnt))
                                 .collect(toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDtoResponse getEmployeeById(Integer id) {
        return employeeEntityToEmployeeDtoMapper.mapEntityToDto(employeeRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = false)
    public EmployeeDtoResponse createEmployee(EmployeeDtoCreateRequest employeeDtoCreateRequest) {

        EmployeeEntity employeeEntity = employeeDtoPostRequestToEmployeeEntityMapper.mapDtoPostRequestToEntity(employeeDtoCreateRequest);
//        employeeEntity.setDepartment(departmentRepository.findById(employeeDtoCreateRequest.getDepartmentId()).orElseThrow());

        // alte actiuni pe entity
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);

        return employeeEntityToEmployeeDtoMapper.mapEntityToDto(savedEntity);
    }

    @Transactional(readOnly = false)
    public List<EmployeeDtoResponse> createEmployees(List<EmployeeDtoCreateRequest> employeeDtoCreateRequestList) {

        return employeeDtoCreateRequestList.stream()
                                           .map(emplReq -> employeeDtoPostRequestToEmployeeEntityMapper.mapDtoPostRequestToEntity(emplReq))
                                           .map(employeeEntity -> employeeRepository.save(employeeEntity))
                                           .map(employeeEntitySaved -> employeeEntityToEmployeeDtoMapper.mapEntityToDto(employeeEntitySaved))
                                           .collect(toList());
    }

    @SneakyThrows
    @Transactional(readOnly = false)
    public List<EmployeeDtoResponse> createEmployeesFromFile(MultipartFile file) {

        if(file.isEmpty()){
            // throw exception
        }

        byte[] bytes = file.getBytes();
        String fileContent = new String(bytes);
        String[] rows = fileContent.split("\n");

        List<EmployeeDtoCreateRequest> toCreate = new ArrayList<>();

        for(String row : rows){
            String[] rowSplitted = row.split(",");
            if (rowSplitted.length != 0) {
                EmployeeDtoCreateRequest employeeDtoCreateRequest = EmployeeDtoCreateRequest.builder()
                                                                         .job(rowSplitted[0])
                                                                         .name(rowSplitted[1])
                                                                         .manager(Integer.valueOf(rowSplitted[2]))
                                                                         .salary(Integer.valueOf(rowSplitted[3]))
                                                                         .comision(Integer.valueOf(rowSplitted[4]))
                                                                         .departmentId(Integer.valueOf(rowSplitted[5]))
                                                                         .hiredate(LocalDate.parse(rowSplitted[6]))
                                                                         .build();
                toCreate.add(employeeDtoCreateRequest);
            }
        }

        return createEmployees(toCreate);
    }

    @Transactional
    public EmployeeDtoResponse updateEmployee(EmployeeDtoUpdateRequest employeeDtoUpdateRequest) {

        Optional<EmployeeEntity> byId = employeeRepository.findById(employeeDtoUpdateRequest.getId());
        EmployeeEntity employeeEntity = byId.orElseThrow(() -> new EmployeeNotFoundException("No employee found for given id: " + employeeDtoUpdateRequest.getId()));
        // setam campurile ce vrem sa fie updatate
        if (employeeDtoUpdateRequest.getComision() != null){ // facem update doar daca exista
            employeeEntity.setComision(employeeDtoUpdateRequest.getComision());
        }
        employeeEntity.setJob(employeeDtoUpdateRequest.getJob());
        employeeEntity.setName(employeeDtoUpdateRequest.getName());
        employeeEntity.setManager(employeeDtoUpdateRequest.getManager());


//        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity); // acest save e facut automat de transactional

        return employeeEntityToEmployeeDtoMapper.mapEntityToDto(employeeEntity);
    }

    @Transactional
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

}
