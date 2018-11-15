package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.ResPersonWorkExpeService;
import com.ccicnavi.bims.resource.dao.ResPersonWorkExpeDao;
import com.ccicnavi.bims.resource.pojo.ResPersonWorkExpeDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ResPersonWorkExpeServiceImpl implements ResPersonWorkExpeService {
    @Autowired
    ResPersonWorkExpeDao resPersonWorkExpeDao;

    /**
     *查询人员工作经历
     */
    @Override
    public List<ResPersonWorkExpeDO> listResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.listResPersonWorkExpeDO(resPersonWorkExpeDO);
    }

    /**
     *新增人员工作经历
     */
    @Override
    public Integer insertResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.insertResPersonWorkExpeDO(resPersonWorkExpeDO);
    }

    /**
     *更改人员工作经历
     */
    @Override
    public Integer updateResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.updateResPersonWorkExpeDO(resPersonWorkExpeDO);
    }

    /**
     *删除人员工作经历
     */
    @Override
    public Integer deleteResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.deleteResPersonWorkExpeDO(resPersonWorkExpeDO);
    }

    /**
     *根据主键查询人员工作经历
     */
    @Override
    public ResPersonWorkExpeDO getResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.getResPersonWorkExpeDO(resPersonWorkExpeDO);
    }
}
