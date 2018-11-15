package com.ccicnavi.bims.document;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = {"com.ccicnavi.bims.document.*"})
@SpringBootApplication
public class EntranceDocumentWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceDocumentWebApplication.class,args);
    }
}
