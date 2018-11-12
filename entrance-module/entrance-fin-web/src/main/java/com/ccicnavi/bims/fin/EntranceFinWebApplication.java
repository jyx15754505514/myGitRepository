package com.ccicnavi.bims.fin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.ccicnavi.bims.fin.controller")
public class EntranceFinWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceFinWebApplication.class, args);
    }
}
