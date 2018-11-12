package com.ccicnavi.bims.fin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class FinApplication {

    public static void main(String[] args) throws InterruptedException{

        SpringApplication.run(FinApplication.class, args);

        new CountDownLatch(1).await(); //hold住应用，防止provider退出
    }
}
