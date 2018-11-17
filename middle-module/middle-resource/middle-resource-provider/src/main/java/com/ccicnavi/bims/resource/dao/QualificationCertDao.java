package com.ccicnavi.bims.resource.dao;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.QualificationCertDO;

import java.util.List;

public interface QualificationCertDao {
    /**
     *查询人员资格证书
     */
    public List<QualificationCertDO> listQualificationCertDO(QualificationCertDO qualificationCertDO) ;

    /**
     *新增人员资格证书
     */
    public Integer insertQualificationCertDO(QualificationCertDO qualificationCertDO) ;

    /**
     *更改人员资格证书
     */
    public Integer updateQualificationCertDO(QualificationCertDO qualificationCertDO) ;

    /**
     *删除人员资格证书
     */
    public Integer deleteQualificationCertDO(QualificationCertDO qualificationCertDO) ;

    /**
     *根据主键查询人员资格证书
     */
    public QualificationCertDO getQualificationCertDO(QualificationCertDO qualificationCertDO) ;

    /**
     *分页查询人员资格证书
     */
    public PageBean<QualificationCertDO> getQualificationCertPage(PageParameter<QualificationCertDO> pageParameter);
}
