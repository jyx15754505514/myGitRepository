package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.StringTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaStringTest {

    @Reference(timeout = 1000, url = "dubbo://127.0.0.1:20888")
    StringTemplate stringTemplate;

    @Test
    public void add() {
        String key = "key4";
        String value = "value";
        stringTemplate.add(key, value);
        System.out.println("添加缓存成功");
    }

    @Test
    public void get() {
        String key = "key4";
        Object value = stringTemplate.get(key);
        System.out.println("缓存key=" + value);
    }

    @Test
    public void delete() {
        String key = "key4";
        Boolean delete = stringTemplate.delete(key);
        System.out.println("删除缓存:" + delete);
    }

    @Test
    public void hasKey() {
        String key = "key4";
        Boolean persist = stringTemplate.hasKey(key);
        System.out.println("缓存存在吗？" + persist);
    }

}
