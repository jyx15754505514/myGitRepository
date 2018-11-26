package com.ccicnavi.bims.zooadmin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@EnableAutoConfiguration
@EnableAdminServer
public class ZooAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooAdminApplication.class, args);
    }
}
