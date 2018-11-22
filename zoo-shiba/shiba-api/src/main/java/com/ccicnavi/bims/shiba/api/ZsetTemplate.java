package com.ccicnavi.bims.shiba.api;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface ZsetTemplate {

    /**
     * 添加value到排序集key，或者score如果已存在则更新它。
     *
     * @param key
     * @param value
     * @param score
     * @return
     */
    Boolean add(Object key, Object value, double score);

    /**
     * 根据key查询start-end的缓存
     *
     * @param key
     * @return
     */
    Set range(Object key, long start, long end);

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
    boolean hasKey(Object key);

    /**
     * values从排序集中删除。
     *
     * @param key
     * @param value
     * @return
     */
    Long remove(Object key, Object... value);

    /**
     * 删除有序集之间start和end之间的元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    Long removeRange(Object key, long start, long end);

    /**
     * 查看key缓存map的大小
     *
     * @param key
     * @return
     */
    Long size(Object key);

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
