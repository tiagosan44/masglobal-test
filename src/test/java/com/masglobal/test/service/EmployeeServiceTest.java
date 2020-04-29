package com.masglobal.test.service;

import com.masglobal.test.configuration.EmployeeNotFoundException;
import com.masglobal.test.data.DataAccess;
import com.masglobal.test.data.EmployeeData;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeServiceTest {

    @Mock
    DataAccess dataAccess;

    @Mock
    EmployeeService employeeService;

    @BeforeEach
    void setup() {
        employeeService = new EmployeeServiceImpl(dataAccess);
    }

    @Test
    void shouldGetEmployees() {
        Mono<List<EmployeeData>> employeeDataList = Mono.just(Mockito.mock(List.class));
        given(dataAccess.getEmployees()).willReturn(employeeDataList);

        employeeService.getEmployees();
        then(dataAccess).should(times(1)).getEmployees();
    }

    @Test
    void shouldGetEmployeeById() {
        Short anyShort = 0;
        Mono<List<EmployeeData>> employeeDataList = Mono.just(Mockito.mock(List.class));
        given(dataAccess.getEmployees()).willReturn(employeeDataList);

        assertThrows(EmployeeNotFoundException.class, () -> employeeService.getEmployeeById(anyShort));

        then(dataAccess).should(times(1)).getEmployees();
    }
}
