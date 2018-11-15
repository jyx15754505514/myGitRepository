package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SpecialNeedDao;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpecialNeedDaoImpl implements SpecialNeedDao {
    @Override
    public List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").select("listSpecialNeed").params(specialNeed).execute();
    }

    @Override
    public int saveSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").insert("saveSpecialNeed").params(specialNeed).execute();
    }

    @Override
    public int removeSpecialNeed(String needUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",needUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSpecialNeed").params(data).execute();
    }

    @Override
    public int updateSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").update("updateSpecialNeed").params(specialNeed).execute();
    }

    @Override
    public SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed) {
        return EqlUtils.getInstance("druid").select("getSpecialNeed").params(specialNeed).execute();
    }
}
