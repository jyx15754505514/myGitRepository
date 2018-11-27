package com.ccicvavi.bims.entranceall;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ccicnavi.bims.system.*"})
public class EntranceAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntranceAllApplication.class, args);
    }
}
