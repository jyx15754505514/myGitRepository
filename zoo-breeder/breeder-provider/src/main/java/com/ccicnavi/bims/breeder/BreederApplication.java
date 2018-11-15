package com.ccicnavi.bims.breeder;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.CountDownLatch;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = { "com.ccicnavi.bims.breeder.*" })
@SpringBootApplication
public class BreederApplication {

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(BreederApplication.class, args);
		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}
	
}
