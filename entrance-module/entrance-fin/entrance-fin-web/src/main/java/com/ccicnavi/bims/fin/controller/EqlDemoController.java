package com.ccicnavi.bims.fin.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.fin.api.EqlDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fin")
public class EqlDemoController {

    @Reference(version = "1.0.0", timeout = 10000)
    EqlDemoService eqlDemoService;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return eqlDemoService.sayHello();
    }
}
