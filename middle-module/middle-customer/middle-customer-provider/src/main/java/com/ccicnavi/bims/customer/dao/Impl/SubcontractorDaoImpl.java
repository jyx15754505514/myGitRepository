package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import com.ccicnavi.bims.customer.util.EqlUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubcontractorDaoImpl implements SubcontractorDao {
    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").select("listSubcontractor").params(subcontractor).execute();
    }

    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").insert("saveSubcontractor").params(subcontractor).execute();
    }

    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcontractorUuid.split(","));
        return EqlUtils.getInstance("druid").update("removeSubcontractor").params(data).execute();
    }

    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").update("updateSubcontractor").params(subcontractor).execute();
    }

    @Override
    public SubcontractorDO getSubcontractor(SubcontractorDO subcontractor) {
        return EqlUtils.getInstance("druid").select("getSubcontractor").params(subcontractor).execute();
    }
}
