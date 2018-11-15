package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.api.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerDemoController {


    @Reference(version = "1.0.0",timeout = 1000,url = "dubbo://127.0.0.1:20883")
    DemoService demoService;

    @RequestMapping("/sayHello")
    public String sayHello(String name){
        return demoService.sayHello(name);
    }
}
