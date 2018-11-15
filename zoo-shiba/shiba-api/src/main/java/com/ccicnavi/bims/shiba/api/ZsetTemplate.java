package com.ccicnavi.bims.shiba.api;

import java.util.Set;

public interface ZsetTemplate {

    Boolean add(Object object, Set<Object> set, double score);

    Set members(Object key);

    Boolean delete(Object key);

    boolean hasKey(Object key);

}
