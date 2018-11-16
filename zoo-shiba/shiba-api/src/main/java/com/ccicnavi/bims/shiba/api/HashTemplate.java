package com.ccicnavi.bims.shiba.api;

import java.util.Map;

public interface HashTemplate {

    /**
     * 添加hash类型的缓存
     *
     * @param key
     * @param map
     */
    void putAll(Object key, Map<Object, Object> map);

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
     * 查看缓存key中是否存在Map的key是key1的
     *
     * @param key
     * @return
     */
    Boolean hasKey(Object key);
}
