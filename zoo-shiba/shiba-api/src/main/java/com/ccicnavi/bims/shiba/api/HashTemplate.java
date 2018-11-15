package com.ccicnavi.bims.shiba.api;

import java.util.Map;

public interface HashTemplate {

    void putAll(Object key, Map<Object, Object> map);

    Map<Object, Object> entries(Object key);

    void delete(Object key);

    Boolean hasKey(Object key);
}
