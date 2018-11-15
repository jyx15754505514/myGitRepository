package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaHashTest {

    @Reference(timeout = 1000, url = "dubbo://127.0.0.1:20888")
    HashTemplate hashRedisTemplate;

    @Test
    public void putAll() {
        Object key = "key111";
        Map<Object, Object> map = new HashMap<>();
        map.put("map1", "111111");
        map.put("map2", "2222222");
        hashRedisTemplate.putAll(key, map);
        System.out.println("添加缓存成功");
    }

    @Test
    public void entries() {
        String key = "key111";
        Map<Object, Object> entries = hashRedisTemplate.entries(key);
        System.out.println(key + "的缓存=" + entries);
    }

    @Test
    public void delete() {
        String key = "key111";
        hashRedisTemplate.delete(key);
        System.out.println("删除成功");
    }

    @Test
    public void hasKey() {
        String key = "key111";
        Boolean aBoolean = hashRedisTemplate.hasKey(key);
        System.out.println("缓存为true存在=" + aBoolean);
    }
}
