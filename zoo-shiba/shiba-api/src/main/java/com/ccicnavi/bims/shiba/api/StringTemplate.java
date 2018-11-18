package com.ccicnavi.bims.shiba.api;

public interface  StringTemplate {

    /**
     * 添加String类型的缓存
     *
     * @param key
     * @param value
     */
    void add(Object key,Object value);

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
    Object getSn(Object key,long start,long end);


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

}
