package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.SetTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaSetTest {

    @Reference(timeout = 1000, url = "dubbo://127.0.0.1:20888")
    SetTemplate setTemplate;

    @Test
    public void add() {
        Set set = new HashSet<>();
        set.add("key1");
        set.add("key2");
        String key = "value";
        setTemplate.add(key, set, "key3", "key4");
        System.out.println("添加缓存成功");
    }

    @Test
    public void members() {
        String key = "value";
        Set members = setTemplate.members(key);
        System.out.println(key + "的缓存=" + members);
    }

    @Test
    public void delete() {
        String key = "value";
        Boolean remove = setTemplate.delete(key);
        System.out.println("删除缓存成功" + remove);
    }

    @Test
    public void persist() {
        String key = "value";
        Boolean persist = setTemplate.hasKey(key);
        System.out.println("缓存存在吗？" + persist);
    }

    @Test
    public void size() {
        Long size = setTemplate.size("value");
        System.out.println(size);
    }

    @Test
    public void remove() {
        setTemplate.remove("value", "key3");
    }
    
}
