package com.ccicnavi.bims.shiba.service;

import org.springframework.stereotype.Service;
import com.ccicnavi.bims.shiba.api.ListTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@Service
public class ListTemplateImpl implements ListTemplate {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 单个添加list类型的缓存
     *
     * @param key
     * @param list
     * @return
     */
    public Long rightPush(Object key, Object list) {
        ListOperations<Object, Object> listOperations = redisTemplate.opsForList();
        return listOperations.rightPush(key, list);
    }

    /**
     * 多个添加list类型的缓存
     *
     * @param key
     * @param object
     * @return
     */
    public Long rightPushAll(Object key, Object... object) {
        ListOperations<Object, Object> listOperations = redisTemplate.opsForList();
        return listOperations.rightPushAll(key, object);
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
     * 查看缓存是否存在
     *
     * @param key
     * @return
     */
    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 查询缓存key的start-end间的值
     *
     * @param key
     * @param start
     * @param end
     */
    public List range(Object key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 查看缓存大小
     * @param key
     * @return
     */
    public Long size(Object key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 根据下角标查询key
     * @param key
     * @param index
     * @return
     */
    public Object index(Object key, long index){
        return redisTemplate.opsForList().index(key,index);
    }
}
