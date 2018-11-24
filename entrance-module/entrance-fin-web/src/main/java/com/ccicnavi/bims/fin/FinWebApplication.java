package com.ccicnavi.bims.fin;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = { "com.ccicnavi.bims.fin.*" ,"com.ccicnavi.bims.sso.*" }) // 将该包下的文件纳入容器中
@SpringBootConfiguration
@SpringBootApplication
public class FinWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinWebApplication.class, args);
    }
}
