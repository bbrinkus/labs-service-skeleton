package com.brinkus.labs.skeleton.boot;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.brinkus.labs.skeleton", "com.brinkus.labs" })
@EnableAutoConfiguration
public class Application {

    Application() {
        // default hidden constructor
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .web(true)
                .run(args);
    }

}
