package com.ccicnavi.bims.customer.provider;

import java.util.Date;

import com.ccicnavi.bims.customer.api.DemoService;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}