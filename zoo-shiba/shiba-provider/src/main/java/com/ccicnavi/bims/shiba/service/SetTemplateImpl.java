package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.shiba.api.SetTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class SetTemplateImpl implements SetTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 添加set类型的缓存
     *
     * @param key
     * @param value
     */
    public void add(Object key, Object... value) {
        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    public Set members(Object key) {
        return redisTemplate.opsForSet().members(key);
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
    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 查看缓存key的大小
     *
     * @param key
     * @return
     */
    public Long size(Object key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 删除key缓存的values元素
     *
     * @param key
     * @param value
     * @return
     */
    public Long remove(Object key, Object... value) {
        return redisTemplate.opsForSet().remove(key, value);
    }

    /**
     * 判断 value 元素是否是集合 key 的成员
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean isMember(Object key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
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
