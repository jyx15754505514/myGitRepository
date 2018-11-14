package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.ResQualificationCertDao;
import com.ccicnavi.bims.resource.pojo.ResQualificationCertDO;
import org.n3r.eql.Eql;

import java.util.List;

/**
 * @Author:
 * @Description:
 * @Date: Created in ${Time} 2018/11/14
 * @Modified By:
 */
public class ResQualificationCertDaoImpl implements ResQualificationCertDao {
    /**
     *查询人员资格证书
     */
    @Override
    public List<ResQualificationCertDO> listResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return new Eql().select("listResQualificationCertDO").params(resQualificationCertDO).returnType(ResQualificationCertDO.class).execute();
    }

    /**
     *新增人员资格证书
     */
    @Override
    public Integer insertResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return new Eql().insert("insertResQualificationCertDO").params(resQualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *更改人员资格证书
     */
    @Override
    public Integer updateResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return new Eql().insert("updateResQualificationCertDO").params(resQualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *删除人员资格证书
     */
    @Override
    public Integer deleteResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return new Eql().insert("deleteResQualificationCertDO").params(resQualificationCertDO).returnType(Integer.class).execute();
    }

    /**
     *根据主键查询人员资格证书
     */
    @Override
    public ResQualificationCertDO getResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return new Eql().selectFirst("getResQualificationCertDO").params(resQualificationCertDO).returnType(ResQualificationCertDO.class).execute();
    }
}
