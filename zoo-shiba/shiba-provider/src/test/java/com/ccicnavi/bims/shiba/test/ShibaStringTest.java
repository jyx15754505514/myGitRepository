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
    public void set() {
        stringTemplate.set("102", "112");
        System.out.println("添加缓存成功");
    }

    @Test
    public void get() {
        String key = "102";
        Object value = stringTemplate.get(key);
        System.out.println("缓存key=" + value);
    }

    @Test
    public void getSn() {
        String key = "key4";
        Object value = stringTemplate.getSn(key, 0, 1);
        System.out.println("缓存key=" + value);
    }

    @Test
    public void delete() {
        String key = "key102";
        Boolean delete = stringTemplate.delete(key);
        System.out.println("删除缓存:" + delete);
    }

    @Test
    public void hasKey() {
        String key = "key4";
        Boolean persist = stringTemplate.hasKey(key);
        System.out.println("缓存存在吗？" + persist);
    }

    @Test
    public void size() {
        Long size = stringTemplate.size("key4");
        System.out.println(size);
    }

    @Test
    public void append() {
        stringTemplate.append("102", "103");
        String stringValueAppend = stringTemplate.get("102") + "";
        System.out.println("通过append(K key, String value)方法修改后的字符串:" + stringValueAppend);
    }

    @Test
    public void getAndSet() {
        stringTemplate.getAndSet("key4", "ccc");
        String stringValueAppend = stringTemplate.get("key4") + "";
        System.out.println("通过append(K key, String value)方法修改后的字符串:" + stringValueAppend);
    }

}
