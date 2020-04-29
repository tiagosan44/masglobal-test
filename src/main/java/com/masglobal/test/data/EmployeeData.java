package com.masglobal.test.data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeData {

    Short id;

    String name;

    String contractTypeName;

    Short roleId;

    String roleName;

    String roleDescription;

    Long monthlySalary;

    Long hourlySalary;
}
