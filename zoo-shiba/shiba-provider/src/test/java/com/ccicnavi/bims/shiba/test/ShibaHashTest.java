package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@Slf4j
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
        map.put("map3", "3333333");
        map.put("map4", "4444444");
        map.put("map5", "5555555");
        hashRedisTemplate.delete(key);
        hashRedisTemplate.putAll(key, map);
        System.out.println("添加缓存成功");
    }

    @Test
    public void entries() {
        String key = "key222";
        Map<Object, Object> entries = hashRedisTemplate.entries(key);
        System.out.println(key + "的缓存:" + entries);
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

    @Test
    public void put() {
        String key = "key222";
        hashRedisTemplate.delete(key);
        hashRedisTemplate.put(key, "mapKey2", "111");
        System.out.println("添加缓存成功");
    }

    @Test
    public void get() {
        String key = "key222";
        String map = "mapKey2";
        Object value = hashRedisTemplate.get(key, map);
        System.out.println(key + "缓存:" + map + " = " + value);
    }

    @Test
    public void size() {
        String key = "key111";
        Long size = hashRedisTemplate.size(key);
        System.out.println("缓存大小：" + size);

    }

    @Test
    public void multiGet() {
        String key = "key111";
        List<Object> keys = new ArrayList<>();
        keys.add("map1");
        keys.add("map2");
        List values = hashRedisTemplate.multiGet(key, keys);
        System.out.println(key + "[map1,map2]:" + values);
    }

    @Test
    public void keys() {
        Set keys = hashRedisTemplate.keys("key111");
        System.out.println(keys);
    }

    @Test
    public void values() {
        List values = hashRedisTemplate.values("key111");
        System.out.println(values);
    }
}
