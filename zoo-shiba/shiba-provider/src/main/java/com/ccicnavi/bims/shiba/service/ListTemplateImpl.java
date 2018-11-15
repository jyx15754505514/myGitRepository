package com.ccicnavi.bims.shiba.service;

import com.alibaba.dubbo.config.annotation.Service;
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
     * 添加list类型的缓存
     *
     * @param key
     * @param list
     * @return
     */
    public Long rightPush(Object key, List<Object> list) {
        ListOperations<Object, Object> listOperations = redisTemplate.opsForList();
        return listOperations.rightPush(key, list);
    }

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    public List<Object> range(Object key) {
        List range = redisTemplate.opsForList().range(key, 0, 99);
        return range;
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

}
