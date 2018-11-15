package com.ccicnavi.bims.order;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = { "com.ccicnavi.bims.order.*" }) // 将该包下的文件纳入容器中
@SpringBootApplication
public class EntranceOrderWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntranceOrderWebApplication.class, args);
    }

}
