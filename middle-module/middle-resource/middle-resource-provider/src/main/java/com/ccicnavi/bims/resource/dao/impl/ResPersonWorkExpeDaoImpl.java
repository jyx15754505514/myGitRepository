package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.ResPersonWorkExpeDao;
import com.ccicnavi.bims.resource.pojo.ResPersonWorkExpeDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResPersonWorkExpeDaoImpl implements ResPersonWorkExpeDao {
    /**
     *查询人员工作经历
     */
    @Override
    public List<ResPersonWorkExpeDO> listResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return new Eql().select("listResPersonWorkExpeDO").params(resPersonWorkExpeDO).returnType(ResPersonWorkExpeDO.class).execute();
    }

    /**
     *新增人员工作经历
     */
    @Override
    public Integer insertResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return new Eql().insert("insertResPersonWorkExpeDO").params(resPersonWorkExpeDO).returnType(Integer.class).execute();
    }

    /**
     *更改人员工作经历
     */
    @Override
    public Integer updateResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return new Eql().insert("updateResPersonWorkExpeDO").params(resPersonWorkExpeDO).returnType(Integer.class).execute();
    }

    /**
     *删除人员工作经历
     */
    @Override
    public Integer deleteResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return new Eql().insert("deleteResPersonWorkExpeDO").params(resPersonWorkExpeDO).returnType(Integer.class).execute();
    }

    /**
     *根据主键查询人员工作经历
     */
    @Override
    public ResPersonWorkExpeDO getResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return new Eql().selectFirst("getResPersonWorkExpeDO").params(resPersonWorkExpeDO).returnType(ResPersonWorkExpeDO.class).execute();
    }
}
