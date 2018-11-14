package com.ccicnavi.bims.resource.dao;


import com.ccicnavi.bims.resource.pojo.ResQualificationCertDO;

import java.util.List;

public interface ResQualificationCertDao {
    /**
     *查询人员资格证书
     */
    public List<ResQualificationCertDO> listResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception;

    /**
     *新增人员资格证书
     */
    public Integer insertResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception;

    /**
     *更改人员资格证书
     */
    public Integer updateResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception;

    /**
     *删除人员资格证书
     */
    public Integer deleteResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception;

    /**
     *根据主键查询人员资格证书
     */
    public ResQualificationCertDO getResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception;
}
