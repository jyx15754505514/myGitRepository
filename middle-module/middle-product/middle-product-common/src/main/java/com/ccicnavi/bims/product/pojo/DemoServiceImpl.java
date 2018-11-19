package com.ccicnavi.bims.product.pojo;
import java.util.Date;


public class DemoServiceImpl{
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }

}