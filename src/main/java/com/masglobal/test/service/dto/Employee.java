package com.masglobal.test.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masglobal.test.service.AnnualSalary;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Employee {

    Short id;

    String name;

    String contractTypeName;

    Short roleId;

    String roleName;

    String roleDescription;

    Long monthlySalary;

    Long hourlySalary;

    Long annualSalaryValue;

    @JsonIgnore
    AnnualSalary annualSalary;
}
