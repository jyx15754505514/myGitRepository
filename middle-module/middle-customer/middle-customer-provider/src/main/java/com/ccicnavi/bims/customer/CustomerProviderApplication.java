package com.ccicnavi.bims.customer;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.CountDownLatch;

@Configuration
@EnableApolloConfig
@ComponentScan(basePackages = { "com.ccicnavi.bims.customer.*" }) // 将该包下的文件纳入容器中
@SpringBootApplication
public class CustomerProviderApplication {

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(CustomerProviderApplication.class, args);

		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}
}
