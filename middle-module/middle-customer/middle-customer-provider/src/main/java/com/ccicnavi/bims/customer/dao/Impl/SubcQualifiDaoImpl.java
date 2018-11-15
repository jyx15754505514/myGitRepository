package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubcQualifiDaoImpl implements SubcQualifiDao {

    @Override
    public List<SubcQualifiDO> listSubcuQuali(SubcQualifiDO subcuQuali) {
        return EqlUtils.getInstance("druid").select("listSubcuQuali").params(subcuQuali).execute();
    }

    @Override
    public int saveSubcuQuali(SubcQualifiDO subcuQuali) {
        return EqlUtils.getInstance("druid").insert("saveSubcuQuali").params(subcuQuali).execute();
    }

    @Override
    public int removeSubcuQuali(String subcQualifiUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcQualifiUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSubcuQuali").params(data).execute();
    }

    @Override
    public int updateSubcuQuali(SubcQualifiDO subcuQuali) {
        return EqlUtils.getInstance("druid").update("updateSubcuQualicuQuali").params(subcuQuali).execute();
    }

    @Override
    public SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) {
        return EqlUtils.getInstance("druid").select("getSubcQuali").params(subcQuali).execute();
    }
}
