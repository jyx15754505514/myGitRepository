package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.StandardInfoService;
import com.ccicnavi.bims.resource.dao.StandardInfoDao;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;

import java.util.List;

@Service
public class StandardInfoServiceImpl implements StandardInfoService{

    @Reference
    StandardInfoDao standardInfoDao;

    @Override
    public List<StandardInfoDO> listStandardInfoDO(StandardInfoDO standardInfoDO){
        return standardInfoDao.listStandardInfoDO(standardInfoDO);
    }

    @Override
    public Integer insertStandardInfoDO(StandardInfoDO standardInfoDO){
        return standardInfoDao.insertStandardInfoDO(standardInfoDO);
    }

    @Override
    public Integer updateStandardInfoDO(StandardInfoDO standardInfoDO){
        return standardInfoDao.updateStandardInfoDO(standardInfoDO);
    }

    @Override
    public Integer deleteStandardInfoDO(StandardInfoDO standardInfoDO){
        return standardInfoDao.deleteStandardInfoDO(standardInfoDO);
    }

    @Override
    public StandardInfoDO getStandardInfoDO(StandardInfoDO standardInfoDO){
        return standardInfoDao.getStandardInfoDO(standardInfoDO);
    }
    
}
