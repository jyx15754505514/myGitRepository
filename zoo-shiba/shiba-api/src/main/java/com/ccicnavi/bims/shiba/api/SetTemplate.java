package com.ccicnavi.bims.shiba.api;

import java.util.Set;

public interface SetTemplate {

    void add(Object key, Set<Object> value);

    Set members(Object key);

    Boolean delete(Object key);

    Boolean hasKey(Object key);
}
