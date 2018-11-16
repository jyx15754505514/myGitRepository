package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.customer.api.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerDemoController {


    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20883")
    DemoService demoService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return demoService.sayHello();
    }
}
