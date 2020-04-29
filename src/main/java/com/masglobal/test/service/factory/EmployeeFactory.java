package com.masglobal.test.service.factory;

import com.masglobal.test.service.EmployeeType;
import com.masglobal.test.service.dto.Employee;
import com.masglobal.test.service.dto.HourlyEmployee;
import com.masglobal.test.service.dto.MonthlyEmployee;

public class EmployeeFactory {

    public static Employee getEmployee(EmployeeType employeeType) {
        switch (employeeType) {
            case HourlySalaryEmployee:
                return new HourlyEmployee();
            case MonthlySalaryEmployee:
                return new MonthlyEmployee();
            default:
                return null;
        }
    }
}
