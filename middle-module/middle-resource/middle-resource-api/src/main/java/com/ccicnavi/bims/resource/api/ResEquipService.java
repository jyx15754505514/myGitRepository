package com.ccicnavi.bims.resource.api;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface ResEquipService {


    List<Map<String, Object>> findResEquipList(Map map);

    Map<String, Object> getResEquip(Map map);

    Integer insertResEquip(JSONObject map);

    Integer updateResEquip(JSONObject map);

    Integer deleteResEquip(JSONObject map);
}
