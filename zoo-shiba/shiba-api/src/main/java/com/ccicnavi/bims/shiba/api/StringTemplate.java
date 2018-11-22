package com.ccicnavi.bims.shiba.api;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public interface StringTemplate {

    /**
     * 添加String类型的缓存
     *
     * @param key
     * @param value
     */
    void set(Object key, Object value);

    /**
     * 添加String类型的缓存
     *
     * @param key
     * @param value
     */
    void setTime(Object key, Object value, long timeout, TimeUnit unit);

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    Object get(Object key);

    /**
     * 根据key查询缓存
     *
     * @param key
     * @return
     */
    Object getSn(Object key, long start, long end);


    /**
     * 根据key删除缓存
     *
     * @param key
     * @return
     */
    Boolean delete(Object key);

    /**
     * 查看缓存key是否存在
     *
     * @param key
     * @return
     */
    Boolean hasKey(Object key);

    /**
     * 查看缓存大小 开始结尾会有"/",占2
     *
     * @param key
     * @return
     */
    Long size(Object key);

    /**
     * 获取原来key键对应的值并重新赋新值
     *
     * @param key
     * @param value
     * @return
     */
    Object getAndSet(Object key, Object value);


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
