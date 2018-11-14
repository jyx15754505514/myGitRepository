package com.ccicnavi.bims.customer.service;

import com.ccicnavi.bims.customer.api.SpecialNeedService;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialNeedServiceImpl implements SpecialNeedService {

    @Resource
    SpecialNeedService specialNeedService;

    @Override
    public List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed) {
        return specialNeedService.listSpecialNeed(specialNeed);
    }

    @Override
    public int saveSpecialNeed(SpecialNeedDO specialNeed) {
        return specialNeedService.saveSpecialNeed(specialNeed);
    }

    @Override
    public int removeSpecialNeed(String needUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",needUuid.split(","));
        return specialNeedService.removeSpecialNeed(needUuid);
    }

    @Override
    public int updateSpecialNeed(SpecialNeedDO specialNeed) {
        return specialNeedService.updateSpecialNeed(specialNeed);
    }
}
