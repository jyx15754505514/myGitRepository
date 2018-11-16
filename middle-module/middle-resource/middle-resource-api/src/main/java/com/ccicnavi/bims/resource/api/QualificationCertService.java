package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.resource.pojo.QualificationCertDO;

import java.util.List;

public interface QualificationCertService {
    /**
     *查询人员资格证书
     */
    public List<QualificationCertDO> listQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception;

    /**
     *新增人员资格证书
     */
    public Integer insertQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception;

    /**
     *更改人员资格证书
     */
    public Integer updateQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception;

    /**
     *删除人员资格证书
     */
    public Integer deleteQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception;

    /**
     *根据主键查询人员资格证书
     */
    public QualificationCertDO getQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception;
}
