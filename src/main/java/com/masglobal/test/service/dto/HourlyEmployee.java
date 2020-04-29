package com.masglobal.test.service.dto;

public class HourlyEmployee extends Employee {

    public HourlyEmployee() {
        this.annualSalary = () -> this.annualSalaryValue = 120 * this.getHourlySalary() * 12;
    }
}
