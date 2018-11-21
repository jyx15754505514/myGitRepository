package com.ccicnavi.bims.shiba.api;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface HashTemplate {

    /**
     * 添加hash类型的缓存
     *
     * @param key
     * @param map
     */
    void putAll(Object key, Map<String, Object> map);

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    Map<Object, Object> entries(Object key);

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    void delete(Object key);

    /**
     * 删除key缓存的mapkey
     *
     * @param key
     * @return
     */
    void deleteMap(Object key, Object... mapKey);

    /**
     * 查看缓存key中是否存在Map的key是key1的
     *
     * @param key
     * @return
     */
    Boolean hasKey(Object key);

    /**
     * 单个添加缓存
     *
     * @param key
     * @param mapKey
     * @param mapValue
     */
    void put(Object key, Object mapKey, Object mapValue);

    /**
     * 查询key缓存中map的value值
     *
     * @param key
     * @param mapKey
     * @return
     */
    Object get(Object key, Object mapKey);

    /**
     * 查看key缓存map的大小
     *
     * @param key
     * @return
     */
    Long size(Object key);

    /**
     * 查询key缓存中指定map的key的value集合
     *
     * @param key
     * @param keys
     */
    List multiGet(Object key, Collection<Object> keys);

    /**
     * key缓存下的map的key集合
     *
     * @param key
     * @return
     */
    Set keys(Object key);

    /**
     * key缓存下的map的values集合
     *
     * @param values
     * @return
     */
    List values(Object values);

    /**
     * 设置key的超时时间
     *
     * @param key
     * @param timeout
     * @param unit
     * @return
     */
    Boolean expire(Object key, long timeout, TimeUnit unit);
}
