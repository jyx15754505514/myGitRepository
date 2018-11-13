package com.ccicnavi.bims.resource.service;


import com.alibaba.dubbo.config.annotation.Service;

import com.ccicnavi.bims.resource.api.DemoService;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello() {
        return "Hello, Word!";
    }
}