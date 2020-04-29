package com.masglobal.test.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "masglobal-config")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MasGlobalProperties {

    String apiURL;

    String employeesUri;
}
