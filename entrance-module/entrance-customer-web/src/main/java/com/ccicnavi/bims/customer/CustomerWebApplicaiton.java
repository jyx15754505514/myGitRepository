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
public class CustomerWebApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(CustomerWebApplicaiton.class,args);
    }
}
