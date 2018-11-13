package com.ccicnavi.bims.fin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.fin.api.EqlDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fin")
public class EqlDemoController {

    @Reference(version = "1.0.0", timeout = 10000,url = "dubbo://192.168.11.6:20880")
    EqlDemoService eqlDemoService;

    @GetMapping("/sayHello")
    public String sayHello(){
        return eqlDemoService.sayHello();
    }
}
