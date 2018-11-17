package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonTeachService;
import com.ccicnavi.bims.resource.dao.PersonTeachDao;
import com.ccicnavi.bims.resource.pojo.PersonTeachDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Slf4j
@Service
public class PersonTeachServiceImpl  implements PersonTeachService {

    @Autowired
    PersonTeachDao personTeachDao;

    @Override
    public List<PersonTeachDO> listPersonTeach(PersonTeachDO personTeachDo) throws Exception {
        try {
            return personTeachDao.listPersonTeach(personTeachDo);
        } catch (Exception e) {
            log.error("查询人员教育经历列表错误",e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer insertPersonTeach(PersonTeachDO personTeachDo) throws Exception {
        try {
            return personTeachDao.insertPersonTeach(personTeachDo);
        } catch (Exception e) {
            log.error("添加人员教育经历错误",e);
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public Integer updatePersonTeach(PersonTeachDO personTeachDo) throws Exception {
        try {
            return personTeachDao.updatePersonTeach(personTeachDo);
        } catch (Exception e) {
            log.error("更新人员教育信息错误",e);
            e.printStackTrace();
            return  null;
        }
    }

    @Override
    public Integer deletePersonTeach(PersonTeachDO personTeachDo) throws Exception {
        try {
            return personTeachDao.deletePersonTeach(personTeachDo);
        } catch (Exception e) {
            log.error("删除人员教育经历错误",e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PersonTeachDO getPersonTeach(PersonTeachDO personTeachDo) {
        try {
            return personTeachDao.getPersonTeach(personTeachDo);
        } catch (Exception e) {
            log.error("获取人员教育经历信息错误",e);
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public PageBean<PersonTeachDO> getPagePersonTeach(PageParameter<PersonTeachDO> pageParameter) {
        try {
            return personTeachDao.getPgaePersonTeach(pageParameter);
        } catch (Exception e) {
            log.error("查询人员教育经历错误",e);
            e.printStackTrace();
            return  null;
        }
    }
}
