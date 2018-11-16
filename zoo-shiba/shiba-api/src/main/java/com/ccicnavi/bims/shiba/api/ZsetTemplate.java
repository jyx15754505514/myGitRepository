package com.ccicnavi.bims.shiba.api;

import java.util.Set;

public interface ZsetTemplate {

    /**
     * 添加set类型的缓存
     *
     * @param key
     * @param set
     * @param score
     * @return
     */
    Boolean add(Object key, Set<Object> set, double score);

    /**
     * 根据key查询start-end的缓存
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
    boolean hasKey(Object key);

}
