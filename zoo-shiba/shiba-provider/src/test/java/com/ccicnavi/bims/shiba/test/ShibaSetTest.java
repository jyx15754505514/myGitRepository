package com.ccicnavi.bims.shiba.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.ShibaApplication;
import com.ccicnavi.bims.shiba.api.SetTemplate;
import com.ccicnavi.bims.shiba.service.ParamVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShibaApplication.class)
public class ShibaSetTest {

    @Reference(timeout = 1000, url = "dubbo://127.0.0.1:20888")
    SetTemplate setTemplate;

    @Test
    public void add() {
        List<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        ParamVo paramVo = new ParamVo();
        paramVo.setList(list);
        paramVo.setKey("keyyy");
        setTemplate.add(paramVo.getKey(), paramVo.getList());
        System.out.println("添加缓存成功");
    }

    @Test
    public void members() {
        String key = "keyyy";
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
        List<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        setTemplate.remove("keyyy", list);
    }

    @Test
    public void isMember() {
        Boolean iBoolean = setTemplate.isMember("value", "key6");
        System.out.println(iBoolean);
    }
}
