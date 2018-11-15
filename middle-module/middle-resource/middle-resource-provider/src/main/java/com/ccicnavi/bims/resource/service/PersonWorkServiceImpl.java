package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.PersonWorkService;
import com.ccicnavi.bims.resource.dao.PersonWorkDao;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class PersonWorkServiceImpl implements PersonWorkService {
    @Autowired
    PersonWorkDao resPersonWorkDao;

    /**
     *查询人员工作信息
     */
    @Override
    public List<PersonWorkDO> listPersonWorkDO(PersonWorkDO personWorkDO) throws Exception {
        return resPersonWorkDao.listPersonWorkDO(personWorkDO);
    }

    /**
     *新增人员工作信息
     */
    @Override
    public Integer insertPersonWorkDO(PersonWorkDO personWorkDO) throws Exception {
        return resPersonWorkDao.insertPersonWorkDO(personWorkDO);
    }

    /**
     *更改人员工作信息
     */
    @Override
    public Integer updatePersonWorkDO(PersonWorkDO personWorkDO) throws Exception {
        return resPersonWorkDao.updatePersonWorkDO(personWorkDO);
    }

    /**
     *删除人员工作信息
     */
    @Override
    public Integer deletePersonWorkDO(PersonWorkDO personWorkDO) throws Exception {
        return resPersonWorkDao.deletePersonWorkDO(personWorkDO);
    }

    /**
     *根据主键查询人员工作信息
     */
    @Override
    public PersonWorkDO getPersonWorkDO(PersonWorkDO personWorkDO) throws Exception {
        return resPersonWorkDao.getPersonWorkDO(personWorkDO);
    }
}
