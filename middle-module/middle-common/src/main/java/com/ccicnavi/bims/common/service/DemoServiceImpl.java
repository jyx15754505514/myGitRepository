package com.ccicnavi.bims.common.service;
import java.util.Date;


public class DemoServiceImpl{
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}