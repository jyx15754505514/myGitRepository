package com.ccicnavi.bims.certmgr;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = { "com.ccicnavi.bims.certmgr.*" }) // 将该包下的文件纳入容器中
@SpringBootApplication
public class CertmgrWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(CertmgrWebApplication.class, args);
    }
}
