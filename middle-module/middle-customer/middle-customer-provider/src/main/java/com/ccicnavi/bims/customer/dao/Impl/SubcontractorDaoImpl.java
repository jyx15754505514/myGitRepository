package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import org.n3r.eql.Eql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubcontractorDaoImpl implements SubcontractorDao {
    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().select("listSubcontractor").params(subcontractor).execute();
    }

    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().insert("saveSubcontractor").params(subcontractor).execute();
    }

    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcontractorUuid.split(","));
        return new Eql().delete("removeSubcontractor").params(data).execute();
    }

    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        return new Eql().update("updateSubcontractor").params(subcontractor).execute();
    }
}
