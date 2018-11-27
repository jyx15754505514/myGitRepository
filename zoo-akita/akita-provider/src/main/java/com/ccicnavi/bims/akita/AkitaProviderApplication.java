package com.ccicnavi.bims.akita;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;

import java.util.concurrent.CountDownLatch;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

@Import(FdfsClientConfig.class)
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableApolloConfig
@SpringBootApplication
public class AkitaProviderApplication {

	public static void main(String[] args) throws InterruptedException{

		SpringApplication.run(AkitaProviderApplication.class, args);

		new CountDownLatch(1).await(); //hold住应用，防止provider退出
	}
	
}
