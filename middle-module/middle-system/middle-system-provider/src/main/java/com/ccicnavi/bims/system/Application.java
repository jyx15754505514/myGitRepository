package com.ccicnavi.bims.system;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = {"com.ccicnavi.bims.system.*"}) // 将该包下的文件纳入容器中
@SpringBootApplication(scanBasePackages = {
        "com.ccicnavi.bims.system.configuration"
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}