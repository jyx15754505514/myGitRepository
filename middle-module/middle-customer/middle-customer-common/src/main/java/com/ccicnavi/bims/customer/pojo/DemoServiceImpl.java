package com.ccicnavi.bims.customer.pojo;
import java.util.Date;


public class DemoServiceImpl{
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}