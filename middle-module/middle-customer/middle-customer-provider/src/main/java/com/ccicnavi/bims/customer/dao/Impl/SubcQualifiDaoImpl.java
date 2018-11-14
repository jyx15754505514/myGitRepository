package com.ccicnavi.bims.customer.dao.Impl;

import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import org.n3r.eql.Eql;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubcQualifiDaoImpl implements SubcQualifiDao {
    @Override
    public List<SubcQualifiDao> listSubcuQuali(SubcQualifiDO subcuQuali) {
        return new Eql().select("listSubcuQuali").params(subcuQuali).execute();
    }

    @Override
    public int saveSubcuQuali(SubcQualifiDO subcuQuali) {
        return new Eql().insert("saveSubcuQuali").params(subcuQuali).execute();
    }

    @Override
    public int removeSubcuQuali(String subcQualifiUuid) {
        Map<String,Object> data=new HashMap<>();
        data.put("ids",subcQualifiUuid.split(","));
        return new Eql().update("removeSubcuQuali").params(data).execute();
    }

    @Override
    public int updateSubcuQuali(SubcQualifiDO subcuQuali) {
        return new Eql().update("updateSubcuQualicuQuali").params(subcuQuali).execute();
    }
}
