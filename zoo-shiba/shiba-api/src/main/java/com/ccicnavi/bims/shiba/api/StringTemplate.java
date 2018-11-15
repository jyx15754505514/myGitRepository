package com.ccicnavi.bims.shiba.api;

public interface StringTemplate {

    void add(Object key,String value);

    Object get(Object key);

    Boolean delete(Object key);

    Boolean hasKey(Object key);

}
