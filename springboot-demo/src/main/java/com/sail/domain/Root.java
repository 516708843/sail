package com.sail.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource("root.properties")
public class Root {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
    private int lenth=180;

    @Autowired
    Environment environment;

//    String sex = environment.getProperty("root.sex");
}
