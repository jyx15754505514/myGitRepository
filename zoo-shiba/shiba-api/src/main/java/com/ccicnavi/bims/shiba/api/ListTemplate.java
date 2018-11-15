package com.ccicnavi.bims.shiba.api;

import java.util.List;

public interface ListTemplate {

    Long rightPush(Object key, List<Object> list);

    List<Object> range(Object key);

    Boolean delete(Object key);

    Boolean hasKey(Object key);

}
