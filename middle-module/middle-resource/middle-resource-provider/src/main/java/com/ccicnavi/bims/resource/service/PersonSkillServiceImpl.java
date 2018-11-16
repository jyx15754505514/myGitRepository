package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.api.PersonSkillService;
import com.ccicnavi.bims.resource.dao.PersonSkillDao;
import com.ccicnavi.bims.resource.pojo.PersonSkillDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class PersonSkillServiceImpl implements PersonSkillService {

    @Autowired
    PersonSkillDao personSkillDao;

    @Override
    public List<PersonSkillDO> listPersonSkillDO(PersonSkillDO personSkillDO) {
        List<PersonSkillDO> personSkillDOList = null;
        try {
            personSkillDOList = personSkillDao.listPersonSkillDO(personSkillDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("职称信息列表获取失败" + e);
        }
        return personSkillDOList;
    }

    @Override
    public Integer insertPersonSkillDO(PersonSkillDO personSkillDO) {
        Integer num = 0;
        try {
            num = personSkillDao.insertPersonSkillDO(personSkillDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("职称信息对象新增失败" + e);
        }
        return num;
    }

    @Override
    public Integer updatePersonSkillDO(PersonSkillDO personSkillDO) {
        Integer num = 0;
        try {
            num = personSkillDao.updatePersonSkillDO(personSkillDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("职称信息对象修改失败" + e);
        }
        return num;
    }

    @Override
    public Integer deletePersonSkillDO(PersonSkillDO personSkillDO) {
        Integer num = 0;
        try {
            num =  personSkillDao.deletePersonSkillDO(personSkillDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("职称信息对象删除失败" + e);
        }
        return num;
    }

    @Override
    public PersonSkillDO getPersonSkillDO(PersonSkillDO personSkillDO) {
        PersonSkillDO personSkill = null;
        try {
            personSkill =  personSkillDao.getPersonSkillDO(personSkillDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("职称信息对象获取失败" + e);
        }
        return personSkill;
    }
}