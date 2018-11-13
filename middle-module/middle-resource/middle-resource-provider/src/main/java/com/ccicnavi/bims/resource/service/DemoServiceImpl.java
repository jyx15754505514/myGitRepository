package com.ccicnavi.bims.resource.service;
import java.util.Date;


import com.alibaba.dubbo.config.annotation.Service;

import com.ccicnavi.bims.resource.service.api.DemoService;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello() {
        return "Hello, Word!";
    }
}