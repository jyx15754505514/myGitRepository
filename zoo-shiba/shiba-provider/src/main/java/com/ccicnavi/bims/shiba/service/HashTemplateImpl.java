package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@Service
public class HashTemplateImpl implements HashTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加hash类型的缓存
     *
     * @param key
     * @param map
     */
    public void putAll(Object key, Map<Object, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    public Map<Object, Object> entries(Object key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    public void delete(Object key) {
        redisTemplate.delete(key);
    }


    /**
     * 查看缓存key中是否存在Map的key是key1的
     *
     * @param key
     * @return
     */
    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }
}
