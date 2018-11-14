package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.SealService;
import com.ccicnavi.bims.resource.dao.SealDao;
import com.ccicnavi.bims.resource.pojo.SealDO;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class SealSeriveImpl implements SealService {

    @Autowired
    SealDao sealDao;

    @Override
    public List<SealDO> listSealDO(SealDO sealDO){
        return sealDao.listSealDO(sealDO);
    }

    @Override
    public Integer insertSealDO(SealDO sealDO){
        return sealDao.insertSealDO(sealDO);
    }

    @Override
    public Integer updateSealDO(SealDO sealDO){
        return sealDao.updateSealDO(sealDO);
    }

    @Override
    public Integer deleteSealDO(SealDO sealDO){
        return sealDao.deleteSealDO(sealDO);
    }

    @Override
    public SealDO getSealDO(SealDO sealDO){
        return sealDao.getSealDO(sealDO);
    }

}
