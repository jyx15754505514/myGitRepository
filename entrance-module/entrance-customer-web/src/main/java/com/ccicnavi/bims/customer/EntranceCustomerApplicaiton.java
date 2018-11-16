package com.ccicnavi.bims.customer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.customer.api.DemoService;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = "com.ccicnavi.bims.customer.*")
@SpringBootApplication
public class EntranceCustomerApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(EntranceCustomerApplicaiton.class,args);
    }
}
