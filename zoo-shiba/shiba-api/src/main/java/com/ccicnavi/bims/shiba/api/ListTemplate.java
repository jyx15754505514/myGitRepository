package com.ccicnavi.bims.shiba.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ListTemplate {

    /**
     * 单个添加list类型的缓存
     *
     * @param key
     * @param list
     * @return
     */
    Long rightPush(Object key, Object list);

    /**
     * 多个添加list类型的缓存
     *
     * @param key
     * @param object
     * @return
     */
    Long rightPushAll(Object key, Object... object);

    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    Boolean delete(Object key);

    /**
     * 查看缓存是否存在
     *
     * @param key
     * @return
     */
    Boolean hasKey(Object key);

    /**
     * 根据key查询缓存
     *
     * @param key
     * @param start 起始位置
     * @param end   结束位置
     */
    List range(Object key, long start, long end);

    /**
     * 查看缓存大小
     *
     * @param key
     * @return
     */
    Long size(Object key);

    /**
     * 根据下角标查询key
     *
     * @param key
     * @param index
     * @return
     */
    Object index(Object key, long index);

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
