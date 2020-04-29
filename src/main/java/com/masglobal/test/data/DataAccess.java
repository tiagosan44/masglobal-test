package com.masglobal.test.data;

import reactor.core.publisher.Mono;
import java.util.List;

public interface DataAccess {

    Mono<List<EmployeeData>> getEmployees();
}
