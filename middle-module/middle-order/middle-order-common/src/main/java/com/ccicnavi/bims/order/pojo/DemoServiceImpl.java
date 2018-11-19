package com.ccicnavi.bims.order.pojo;
import java.util.Date;


public class DemoServiceImpl{
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}