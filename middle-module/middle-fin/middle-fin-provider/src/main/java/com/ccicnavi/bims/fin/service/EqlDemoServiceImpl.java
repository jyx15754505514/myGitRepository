package com.ccicnavi.bims.fin.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.fin.api.EqlDemoService;

@Service(version = "1.0.0")
public class EqlDemoServiceImpl implements EqlDemoService {
    @Override
    public String sayHello() {
        return "Hello Word!!!";
    }
}
