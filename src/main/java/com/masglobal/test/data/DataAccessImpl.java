package com.masglobal.test.data;

import com.masglobal.test.configuration.MasGlobalProperties;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DataAccessImpl implements DataAccess{

    @Qualifier("masGlobalWebClient")
    WebClient webClient;

    MasGlobalProperties masGlobalProperties;

    public Mono<List<EmployeeData>> getEmployees() {
        return webClient
                .get()
                .uri(ub -> ub.path(masGlobalProperties.getEmployeesUri())
                        .build())
                .retrieve()
                .bodyToFlux(EmployeeData.class)
                .collectList();
    }
}
