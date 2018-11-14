package com.ccicnavi.bims.resource.api;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface ResEquipTestService {
    List<Map<String, Object>> findResEquipTestList(Map map);

    Map<String, Object> getResEquipTest(Map map);

    Integer insertResEquipTest(JSONObject map);

    Integer updateResEquipTest(JSONObject map);

    Integer deleteResEquipTest(JSONObject map);
}
