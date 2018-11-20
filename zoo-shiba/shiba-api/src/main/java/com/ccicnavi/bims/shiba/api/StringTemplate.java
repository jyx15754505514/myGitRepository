package com.ccicnavi.bims.shiba.api;

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
    void setTime(Object key, Object value,long timeout, TimeUnit unit);

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
     * 查看缓存大小
     *
     * @param key
     * @return
     */
    Long size(Object key);

    /**
     * 在原有的值基础上新增字符串到末尾
     *
     * @param key
     * @param value
     * @return
     */
    Integer append(Object key, String value);

    /**
     * 获取原来key键对应的值并重新赋新值
     *
     * @param key
     * @param value
     * @return
     */
    Object getAndSet(Object key, Object value);

}
