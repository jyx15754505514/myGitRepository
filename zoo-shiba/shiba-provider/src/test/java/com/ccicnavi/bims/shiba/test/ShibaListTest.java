package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.ListTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaListTest {

    @Reference(timeout = 1000,url = "dubbo://127.0.0.1:20880")
    ListTemplate listRedisTemplate;

    @Test
    public void hello(){
        System.out.println(listRedisTemplate.hello("张三"));
    }
}
