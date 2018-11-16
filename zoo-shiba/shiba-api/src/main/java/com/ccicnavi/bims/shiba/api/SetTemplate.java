package com.ccicnavi.bims.shiba.api;

import java.awt.*;
import java.util.Set;

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
     * @param values
     * @return
     */
    Long remove(Object key, Object... values);

    /**
     * 得到key缓存下的set集合
     *
     * @param key
     * @return
     */
    Cursor scan(Object key);
}
