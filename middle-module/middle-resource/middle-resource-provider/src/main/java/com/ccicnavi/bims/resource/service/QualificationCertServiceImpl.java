package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.QualificationCertService;
import com.ccicnavi.bims.resource.dao.QualificationCertDao;
import com.ccicnavi.bims.resource.pojo.QualificationCertDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class QualificationCertServiceImpl implements QualificationCertService {
    @Autowired
    QualificationCertDao resQualificationCertDao;

    /**
     *查询人员资格证书
     */
    @Override
    public List<QualificationCertDO> listQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception {
        return resQualificationCertDao.listQualificationCertDO(qualificationCertDO);
    }

    /**
     *新增人员资格证书
     */
    @Override
    public Integer insertQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception {
        return resQualificationCertDao.insertQualificationCertDO(qualificationCertDO);
    }

    /**
     *更改人员资格证书
     */
    @Override
    public Integer updateQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception {
        return resQualificationCertDao.updateQualificationCertDO(qualificationCertDO);
    }

    /**
     *删除人员资格证书
     */
    @Override
    public Integer deleteQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception {
        return resQualificationCertDao.deleteQualificationCertDO(qualificationCertDO);
    }

    /**
     *根据主键查询人员资格证书
     */
    @Override
    public QualificationCertDO getQualificationCertDO(QualificationCertDO qualificationCertDO) throws Exception {
        return resQualificationCertDao.getQualificationCertDO(qualificationCertDO);
    }
}
