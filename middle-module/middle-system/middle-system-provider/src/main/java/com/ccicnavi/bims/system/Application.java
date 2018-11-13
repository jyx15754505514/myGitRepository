package com.ccicnavi.bims.system;

import com.alibaba.boot.dubbo.autoconfigure.DubboAutoConfiguration;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.CountDownLatch;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableApolloConfig
//@SpringBootApplication

//@EnableAutoConfiguration(exclude={DubboAutoConfiguration.class})
@Configuration()
@EnableApolloConfig
@SpringBootApplication()
public class Application {

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(Application.class, args);

		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}

}

