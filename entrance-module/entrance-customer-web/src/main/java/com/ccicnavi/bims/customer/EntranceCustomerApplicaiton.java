package com.ccicnavi.bims.customer;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = "com.ccicnavi.bims.customer.*")
@SpringBootApplication
public class EntranceCustomerApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(EntranceCustomerApplicaiton.class,args);
    }
}
