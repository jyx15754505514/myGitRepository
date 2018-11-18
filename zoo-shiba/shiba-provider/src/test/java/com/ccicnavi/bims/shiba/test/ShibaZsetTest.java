package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.ZsetTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaZsetTest {

    @Reference(timeout = 1000, url = "dubbo://127.0.0.1:20888")
    ZsetTemplate zsetTemplate;

    @Test
    public void add() {
        String key = "key555";
        zsetTemplate.add(key, "33", 1);
        System.out.println("添加缓存成功");
    }


    @Test
    public void range() {
        String key = "key555";
        Set members = zsetTemplate.range(key, 0, 3);
        System.out.println(key + "的缓存=" + members);
    }

    @Test
    public void delete() {
        String key = "key555";
        zsetTemplate.delete(key);
        System.out.println("删除缓存成功");
    }

    @Test
    public void hasKey() {
        String key = "key555";
        Boolean persist = zsetTemplate.hasKey(key);
        System.out.println("缓存存在吗？" + persist);
    }

    @Test
    public void remove() {
        zsetTemplate.remove("key555", "55555");
    }

    @Test
    public void removeRange() {
        zsetTemplate.removeRange("key555", 1, 2);
    }
}
