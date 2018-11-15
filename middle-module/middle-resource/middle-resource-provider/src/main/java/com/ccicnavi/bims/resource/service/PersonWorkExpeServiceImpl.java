package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.PersonWorkExpeService;
import com.ccicnavi.bims.resource.dao.PersonWorkExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonWorkExpeDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PersonWorkExpeServiceImpl implements PersonWorkExpeService {
    @Autowired
    PersonWorkExpeDao resPersonWorkExpeDao;

    /**
     *查询人员工作经历
     */
    @Override
    public List<PersonWorkExpeDO> listPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.listPersonWorkExpeDO(personWorkExpeDO);
    }

    /**
     *新增人员工作经历
     */
    @Override
    public Integer insertPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.insertPersonWorkExpeDO(personWorkExpeDO);
    }

    /**
     *更改人员工作经历
     */
    @Override
    public Integer updatePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.updatePersonWorkExpeDO(personWorkExpeDO);
    }

    /**
     *删除人员工作经历
     */
    @Override
    public Integer deletePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.deletePersonWorkExpeDO(personWorkExpeDO);
    }

    /**
     *根据主键查询人员工作经历
     */
    @Override
    public PersonWorkExpeDO getPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception {
        return resPersonWorkExpeDao.getPersonWorkExpeDO(personWorkExpeDO);
    }
}
