package com.siit.nationalgrupa3.hr.employee.service;


import com.siit.nationalgrupa3.hr.employee.domain.entity.EmployeeEntity;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoResponse;
import com.siit.nationalgrupa3.hr.employee.domain.model.EmployeeDtoUpdateRequest;
import com.siit.nationalgrupa3.hr.employee.exception.EmployeeNotFoundException;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeDtoPostRequestToEmployeeEntityMapper;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeDtoToEmployeeEntityMapper;
import com.siit.nationalgrupa3.hr.employee.mapper.EmployeeEntityToEmployeeDtoMapper;
import com.siit.nationalgrupa3.hr.employee.repository.DepartmentRepository;
import com.siit.nationalgrupa3.hr.employee.repository.EmployeeRepository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private EmployeeEntityToEmployeeDtoMapper employeeEntityToEmployeeDtoMapper;
    @Mock
    private EmployeeDtoToEmployeeEntityMapper employeeDtoToEmployeeEntityMapper;
    @Mock
    private EmployeeDtoPostRequestToEmployeeEntityMapper employeeDtoPostRequestToEmployeeEntityMapper;

    @Test
    public void getAllEmployees_givenNoEmployees_thenReturnEmptyList(){
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        when(employeeRepository.findAll()).thenReturn(employeeEntityList);

        var allEmployees = employeeService.getAllEmployees();

        assertThat(allEmployees).isNotNull();
        assertThat(allEmployees.isEmpty()).isEqualTo(true);
    }

    @Test
    public void getAllEmployees_givenExistingEmployees_thenReturnEmplList(){
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        var employeeEntity = EmployeeEntity.builder()
                                           .comision(10)
                                           .job("Job")
                                           .build();
        employeeEntityList.add(employeeEntity);
        employeeEntityList.add(employeeEntity);
        employeeEntityList.add(employeeEntity);

        var dto = EmployeeDtoResponse.builder().job("Job").comision(10).build();

        when(employeeRepository.findAll()).thenReturn(employeeEntityList);
//        Mockito.when(employeeEntityToEmployeeDtoMapper.mapEntityToDto(employeeEntity)).thenReturn(dto);
        when(employeeEntityToEmployeeDtoMapper.mapEntityToDto(ArgumentMatchers.any())).thenReturn(dto);

        var allEmployees = employeeService.getAllEmployees();

        assertThat(allEmployees).isNotNull();
        assertThat(allEmployees.size()).isEqualTo(3);
        assertThat(allEmployees.get(0)).isNotNull();
        assertThat(allEmployees.get(0).getJob()).isEqualTo(employeeEntity.getJob());
    }


    @Test
    public void given_existing_employee_when_updating_then_employee_is_updated_and_returned(){
        //Given
        int id = 123;
        String alt_job = "alt job";
        var input = EmployeeDtoUpdateRequest.builder()
                                            .id(id)
                                            .job(alt_job)
                                            .comision(150)
                                            .name("alt name")
                                            .manager(20)
                                            .build();
        var employeeEntity = EmployeeEntity.builder()
                                           .comision(150)
                                           .job(alt_job)
                                           .build();
        var employeeEntityMock = Mockito.mock(EmployeeEntity.class);
        var dto = EmployeeDtoResponse.builder()
                                     .job(alt_job)
                                     .comision(150)
                                     .build();

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employeeEntityMock));
        when(employeeEntityToEmployeeDtoMapper.mapEntityToDto(ArgumentMatchers.any())).thenReturn(dto);

        // When
        var result = employeeService.updateEmployee(input);

        //Then
        Mockito.verify(employeeEntityMock).setJob(alt_job); // verifica ca se petrece o actiune cu mockul respectiv
        Mockito.verify(employeeEntityMock).setComision(input.getComision());
        Mockito.verify(employeeEntityMock).setName(input.getName());

        assertThat(result).isNotNull();
        assertThat(result).isSameAs(dto);
    }

    @Test
    public void given_non_existing_employee_when_updating_then_employee_not_found_exception_is_thrown(){
        //Given
        int id = 123;
        String alt_job = "alt job";
        var input = EmployeeDtoUpdateRequest.builder()
                                            .id(id)
                                            .job(alt_job)
                                            .comision(150)
                                            .name("alt name")
                                            .manager(20)
                                            .build();
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());
        // When
        var throwable = catchThrowable(() -> employeeService.updateEmployee(input));

        //Then
        assertThat(throwable).isNotNull();
        assertThat(throwable).isInstanceOf(EmployeeNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("No employee found for given id: "+id);
    }

    @Test
    public void given_existing_employee_when_updating_then_employee_is_updated_and_returned_argument_captor_example(){
        //Given
        int id = 123;
        String alt_job = "alt job";
        var input = EmployeeDtoUpdateRequest.builder()
                                            .id(id)
                                            .job(alt_job)
                                            .comision(150)
                                            .name("alt name")
                                            .manager(20)
                                            .build();
        var employeeEntity = EmployeeEntity.builder().build();
        var employeeEntityMock = Mockito.spy(EmployeeEntity.class);
        var dto = EmployeeDtoResponse.builder()
                                     .job(alt_job)
                                     .comision(150)
                                     .build();

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employeeEntity));
        when(employeeEntityToEmployeeDtoMapper.mapEntityToDto(ArgumentMatchers.any())).thenReturn(dto);

        // When
        var result = employeeService.updateEmployee(input);

        //Then
        var argumentC = ArgumentCaptor.forClass(EmployeeEntity.class);
        verify(employeeEntityToEmployeeDtoMapper).mapEntityToDto(argumentC.capture());

        var employeeEntityUpdated = argumentC.getValue();
        assertThat(employeeEntityUpdated).isNotNull();
        assertThat(employeeEntityUpdated.getComision()).isEqualTo(input.getComision());
        assertThat(employeeEntityUpdated.getJob()).isEqualTo(input.getJob());
        assertThat(employeeEntityUpdated.getManager()).isEqualTo(input.getManager());
        assertThat(employeeEntityUpdated.getName()).isEqualTo(input.getName());

        assertThat(result).isNotNull();
        assertThat(result).isSameAs(dto);
    }
}
