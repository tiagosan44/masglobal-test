package com.masglobal.test.service;

import com.masglobal.test.service.dto.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeById(Short employeeId);
}
