package com.ccicnavi.bims.order;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.CountDownLatch;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = { "com.ccicnavi.bims.order.*" }) // 将该包下的文件纳入容器中
@SpringBootApplication
public class OrderProviderApplication {

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(OrderProviderApplication.class, args);

		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}
	
}
