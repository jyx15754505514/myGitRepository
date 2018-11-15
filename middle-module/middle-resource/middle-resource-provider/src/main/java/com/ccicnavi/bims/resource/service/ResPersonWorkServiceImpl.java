package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.ResPersonWorkService;
import com.ccicnavi.bims.resource.dao.ResPersonWorkDao;
import com.ccicnavi.bims.resource.pojo.ResPersonWorkDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class ResPersonWorkServiceImpl implements ResPersonWorkService {
    @Autowired
    ResPersonWorkDao resPersonWorkDao;

    /**
     *查询人员工作信息
     */
    @Override
    public List<ResPersonWorkDO> listResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return resPersonWorkDao.listResPersonWorkDO(resPersonWorkDO);
    }

    /**
     *新增人员工作信息
     */
    @Override
    public Integer insertResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return resPersonWorkDao.insertResPersonWorkDO(resPersonWorkDO);
    }

    /**
     *更改人员工作信息
     */
    @Override
    public Integer updateResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return resPersonWorkDao.updateResPersonWorkDO(resPersonWorkDO);
    }

    /**
     *删除人员工作信息
     */
    @Override
    public Integer deleteResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return resPersonWorkDao.deleteResPersonWorkDO(resPersonWorkDO);
    }

    /**
     *根据主键查询人员工作信息
     */
    @Override
    public ResPersonWorkDO getResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception {
        return resPersonWorkDao.getResPersonWorkDO(resPersonWorkDO);
    }
}
