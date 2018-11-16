package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonTeachService;
import com.ccicnavi.bims.resource.dao.PersonTeachDao;
import com.ccicnavi.bims.resource.pojo.PersonTeachDO;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class PersonTeachServiceImpl  implements PersonTeachService {

    @Autowired
    PersonTeachDao personTeachDao;

    @Override
    public List<PersonTeachDO> listPersonTeach(PersonTeachDO personTeachDo) throws Exception {
        return personTeachDao.listPersonTeach(personTeachDo);
    }

    @Override
    public Integer insertPersonTeach(PersonTeachDO personTeachDo) throws Exception {
        return personTeachDao.insertPersonTeach(personTeachDo);
    }

    @Override
    public Integer updatePersonTeach(PersonTeachDO personTeachDo) throws Exception {
        return personTeachDao.updatePersonTeach(personTeachDo);
    }

    @Override
    public Integer deletePersonTeach(PersonTeachDO personTeachDo) throws Exception {
        return personTeachDao.deletePersonTeach(personTeachDo);
    }

    @Override
    public PersonTeachDO getPersonTeach(PersonTeachDO personTeachDo) {
        return personTeachDao.getPersonTeach(personTeachDo);
    }

    @Override
    public PageBean<PersonTeachDO> getPagePersonTeach(PageParameter<PersonTeachDO> pageParameter) {
        return personTeachDao.getPgaePersonTeach(pageParameter);
    }
}
