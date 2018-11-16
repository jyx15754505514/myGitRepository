package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.StringTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@Service
public class StringTemplateImpl implements StringTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加String类型的缓存
     *
     * @param key
     * @param value
     */
    public void add(Object key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    public Object get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    public Boolean delete(Object key) {
        return redisTemplate.delete(key);
    }

    /**
     * 查看缓存key是否存在
     *
     * @param key
     * @return
     */
    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

}

