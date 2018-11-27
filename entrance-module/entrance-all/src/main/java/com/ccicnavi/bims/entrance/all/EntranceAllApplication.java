package com.ccicnavi.bims.entrance.all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ccicnavi.bims.*"})
public class EntranceAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceAllApplication.class, args);
    }
}
