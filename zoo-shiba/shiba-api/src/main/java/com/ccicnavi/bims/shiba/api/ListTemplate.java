package com.ccicnavi.bims.shiba.api;

import java.util.List;

public interface ListTemplate {

    /**
     * 添加list类型的缓存
     *
     * @param key
     * @param list
     * @return
     */
    Long rightPush(Object key, List<Object> list);

    /**
     * 根据key查询缓存
     * @param key
     * @return
     */
    List<Object> range(Object key);

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

}
