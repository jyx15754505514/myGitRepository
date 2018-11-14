package com.ccicnavi.bims.resource.api;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface ResEquipHoldService {
    List<Map<String, Object>> findResEquipHoldList(Map map);

    Map<String, Object> getResEquipHold(Map map);

    Integer insertResEquipHold(JSONObject map);

    Integer updateResEquipHold(JSONObject map);

    Integer deleteResEquipHold(JSONObject map);
}
