package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.ZsetTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class ZsetTemplateImpl implements ZsetTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加value到排序集key，或者score如果已存在则更新它。
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Boolean add(Object key, Object value, double score) {
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.add(key, value, score);
    }


    /**
     * 根据key查询start-end的缓存
     *
     * @param key
     * @return
     */
    public Set range(Object key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
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

    /**
     * values从排序集中删除。
     *
     * @param key
     * @param value
     * @return
     */
    public Long remove(Object key, Object... value) {
        return redisTemplate.opsForZSet().remove(key, value);
    }

    /**
     * 删除有序集之间start和end之间的元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long removeRange(Object key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 查看key缓存map的大小
     *
     * @param key
     * @return
     */
    public Long size(Object key) {
        return redisTemplate.opsForZSet().size(key);
    }

    /**
     * 设置key的超时时间
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    public Boolean expire(Object key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }
}
