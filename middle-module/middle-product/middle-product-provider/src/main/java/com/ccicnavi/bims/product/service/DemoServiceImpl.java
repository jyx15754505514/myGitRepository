package com.ccicnavi.bims.product.service;
import java.util.Date;


import com.alibaba.dubbo.config.annotation.Service;

import com.ccicnavi.bims.product.api.DemoService;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {
	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}