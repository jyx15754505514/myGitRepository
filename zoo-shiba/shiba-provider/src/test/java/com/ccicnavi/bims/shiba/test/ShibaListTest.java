package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.ListTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaListTest {

    @Reference(timeout = 1000, url = "dubbo://127.0.0.1:20888")
    ListTemplate listRedisTemplate;

    @Test
    public void rightPush() {
        Object key = "key11";
        List<Object> list = new ArrayList();
        list.add("list111333");
        list.add("list222555");
        listRedisTemplate.rightPush(key, list);
        System.out.println("添加缓存成功");
    }

    @Test
    public void range() {
        String key = "key11";
        List<Object> range = listRedisTemplate.range(key);
        System.out.println("缓存key=" + range);
    }

    @Test
    public void delete() {
        String key = "key11";
        Boolean delete = listRedisTemplate.delete(key);
        System.out.println("删除缓存:" + delete);
    }

    @Test
    public void hasKey() {
        String key = "key11";
        Boolean persist = listRedisTemplate.hasKey(key);
        System.out.println("缓存是否存在 ？" + persist);
    }

}
