package com.masglobal.test.service;

import com.masglobal.test.configuration.EmployeeNotFoundException;
import com.masglobal.test.data.DataAccess;
import com.masglobal.test.data.EmployeeData;
import com.masglobal.test.service.dto.Employee;
import com.masglobal.test.service.factory.EmployeeFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
// Here I'm using @Service tag from spring framework to map this
// class as a service, this allows to the component scan to find this component
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService{

    DataAccess dataAccess;

    /**
     * Array insertion O(n)
     * @return
     */
    public List<Employee> getEmployees() {
        return dataAccess
                .getEmployees()
                .block()
                .stream()
                .map(this::mapEmployees)
                .collect(Collectors.toList());
    }

    /**
     * Array search O(n)
     * @param employeeId
     * @return
     */
    public Employee getEmployeeById(Short employeeId) {
        return getEmployees()
                .stream()
                .filter(e -> e.getId().equals(employeeId))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + employeeId));
    }

    private Employee mapEmployees(EmployeeData employeeData) {
        Employee newEmployee = EmployeeFactory.getEmployee(EmployeeType.valueOf(employeeData.getContractTypeName()));
        mapEmployee(employeeData, newEmployee);
        newEmployee.getAnnualSalary().calculate();
        return newEmployee;
    }

    private void mapEmployee(EmployeeData employeeData, Employee newEmployee) {
        newEmployee.setId(employeeData.getId());
        newEmployee.setName(employeeData.getName());
        newEmployee.setContractTypeName(employeeData.getContractTypeName());
        newEmployee.setRoleId(employeeData.getRoleId());
        newEmployee.setRoleName(employeeData.getRoleName());
        newEmployee.setMonthlySalary(employeeData.getMonthlySalary());
        newEmployee.setHourlySalary(employeeData.getHourlySalary());
    }
}
