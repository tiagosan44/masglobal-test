package com.masglobal.test.service.dto;

public class MonthlyEmployee extends Employee {

    public MonthlyEmployee() {
        this.annualSalary = () -> this.annualSalaryValue = this.getMonthlySalary() * 12;
    }
}
