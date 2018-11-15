package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.ListTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Service
public class ListTemplateImpl implements ListTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    public String hello(String name){
        ListOperations<Object, Object> boundListOperations = redisTemplate.opsForList();
        boundListOperations.rightPush("name",name);

        return boundListOperations.range("name",0,2).toString();
    }

}
