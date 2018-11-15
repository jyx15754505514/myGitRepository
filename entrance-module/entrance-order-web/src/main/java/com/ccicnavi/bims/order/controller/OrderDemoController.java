package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.order.api.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderDemoController {

    @Reference(version = "1.0.0",timeout = 1000,url = "dubbo://127.0.0.1:20886")
    DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return demoService.sayHello(name);
    }
}
