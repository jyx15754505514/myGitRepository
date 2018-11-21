package com.ccicnavi.bims.shiba.api;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface SetTemplate {

    /**
     * 添加set类型的缓存
     *
     * @param key
     * @param value
     */
    void add(Object key, Object... value);

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    Set members(Object key);

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    Boolean delete(Object key);

    /**
     * 查询缓存中value值是否存在
     *
     * @param key
     * @return
     */
    Boolean hasKey(Object key);

    /**
     * 查看缓存key的大小
     *
     * @param key
     * @return
     */
    Long size(Object key);

    /**
     * 删除key缓存的values元素
     *
     * @param key
     * @param value
     * @return
     */
    Long remove(Object key, Object... value);

    /**
     * 判断 value 元素是否是集合 key 的成员
     *
     * @param key
     * @param value
     * @return
     */
    Boolean isMember(Object key, Object value);

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
