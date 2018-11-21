package com.ccicnavi.bims.shiba.service;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
public class ParamVo {
    private String key;
    private String mapKey;
    private Object value;
    private Map<String, Object> map;
    private List<Object> list;
    private long start;
    private long end;
    private double score;
    private long outTime;
    private TimeUnit unit;
}
