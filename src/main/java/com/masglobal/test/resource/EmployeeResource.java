package com.masglobal.test.resource;

import com.masglobal.test.service.EmployeeService;
import com.masglobal.test.service.dto.Employee;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Here I'm using @RestController tag from spring framework to map this class as a rest
// controller and simplify creation of RESTful web services, this allows to the component scan to find this component

// RequestMapping annotation is used to map web requests to Spring Controller methods

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeResource {

    EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping(value = "/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable short employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
}
