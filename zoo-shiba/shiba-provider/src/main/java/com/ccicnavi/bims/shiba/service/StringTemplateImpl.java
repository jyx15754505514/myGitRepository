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
    public void set(Object key, Object value) {
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
     * 截取key所对应的value字符串
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Object getSn(Object key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
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

    /**
     * 查看缓存大小
     *
     * @param key
     * @return
     */
    public Long size(Object key) {
        return redisTemplate.opsForValue().size(key);
    }

    /**
     * 在原有的值基础上新增字符串到末尾。
     *
     * @param key
     * @param value
     * @return
     */
    public Integer append(Object key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }

    /**
     * 获取原来key键对应的值并重新赋新值
     *
     * @param key
     * @param value
     * @return
     */
    public Object getAndSet(Object key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

}

