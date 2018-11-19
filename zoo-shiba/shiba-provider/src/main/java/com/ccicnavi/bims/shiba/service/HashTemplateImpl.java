package com.ccicnavi.bims.shiba.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.HashTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    /**
     * 单个添加缓存
     *
     * @param key
     * @param mapKey
     * @param mapValue
     */
    public void put(Object key, Object mapKey, Object mapValue) {
        redisTemplate.opsForHash().put(key, mapKey, mapValue);
    }

    /**
     * 查询key缓存中map的value值
     *
     * @param key
     * @param mapKey
     * @return
     */
    public Object get(Object key, Object mapKey) {
        return redisTemplate.opsForHash().get(key, mapKey);
    }

    /**
     * 查看key缓存map的大小
     *
     * @param key
     * @return
     */
    public Long size(Object key) {
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * 查询key缓存中指定map的key的value集合
     *
     * @param key
     * @param keys
     */
    public List multiGet(Object key, List<Object> keys) {
        return redisTemplate.opsForHash().multiGet(key, keys);
    }

    /**
     * key缓存下的map的key集合
     *
     * @param key
     * @return
     */
    public Set keys(Object key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * key缓存下的map的values集合
     *
     * @param values
     * @return
     */
    public List values(Object values) {
        return redisTemplate.opsForHash().values(values);
    }

}
