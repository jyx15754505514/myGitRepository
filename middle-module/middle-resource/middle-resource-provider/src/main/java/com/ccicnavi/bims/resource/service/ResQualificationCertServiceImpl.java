package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.ResQualificationCertService;
import com.ccicnavi.bims.resource.dao.ResQualificationCertDao;
import com.ccicnavi.bims.resource.pojo.ResQualificationCertDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ResQualificationCertServiceImpl implements ResQualificationCertService {
    @Autowired
    ResQualificationCertDao resQualificationCertDao;

    /**
     *查询人员资格证书
     */
    @Override
    public List<ResQualificationCertDO> listResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return resQualificationCertDao.listResQualificationCertDO(resQualificationCertDO);
    }

    /**
     *新增人员资格证书
     */
    @Override
    public Integer insertResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return resQualificationCertDao.insertResQualificationCertDO(resQualificationCertDO);
    }

    /**
     *更改人员资格证书
     */
    @Override
    public Integer updateResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return resQualificationCertDao.updateResQualificationCertDO(resQualificationCertDO);
    }

    /**
     *删除人员资格证书
     */
    @Override
    public Integer deleteResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return resQualificationCertDao.deleteResQualificationCertDO(resQualificationCertDO);
    }

    /**
     *根据主键查询人员资格证书
     */
    @Override
    public ResQualificationCertDO getResQualificationCertDO(ResQualificationCertDO resQualificationCertDO) throws Exception {
        return resQualificationCertDao.getResQualificationCertDO(resQualificationCertDO);
    }
}
