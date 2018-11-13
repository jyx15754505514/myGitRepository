package com.ccicnavi.bims.resource.pojo;


import com.alibaba.dubbo.config.annotation.Service;

import com.ccicnavi.bims.resource.pojo.api.DemoService;

@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello() {
        return "Hello, Word!";
    }
}