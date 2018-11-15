package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.ZsetTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

@Service
public class ZsetTemplateImpl implements ZsetTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加set类型的缓存
     *
     * @param key
     * @param set
     * @param score
     * @return
     */
    public Boolean add(Object key, Set<Object> set, double score) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.add(key, set, score);
    }

    /**
     * 根据key查询start-end的缓存
     *
     * @param key
     * @return
     */
    public Set members(Object key) {
        return redisTemplate.opsForZSet().range(key, 0, 99);
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
     * 查询缓存中value值是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

}
