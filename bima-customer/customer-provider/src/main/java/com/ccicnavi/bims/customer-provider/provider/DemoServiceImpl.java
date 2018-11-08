package com.ccicnavi.bims.customer-provider.provider;

import java.util.Date;

import com.ccicnavi.bims.customer-api.DemoService;

import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.stereotype.Component;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}