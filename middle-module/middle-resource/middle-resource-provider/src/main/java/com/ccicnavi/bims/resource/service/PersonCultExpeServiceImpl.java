package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.PersonCultExpeService;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.dao.PersonCultExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class PersonCultExpeServiceImpl implements PersonCultExpeService {

    @Autowired
    private PersonCultExpeDao personCultExpeDao;

    /*
    *@program: [personCultExpe]
    *@description: 查询人员培训经历
    *@return: java.util.List<com.ccicnavi.bims.resource.pojo.PersonCultExpeDO>
    *@author: XiaWei
    *@create: 2018/11/16 10:24
    */
    @Override
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) {
        List<PersonCultExpeDO> personCultExpeList = null;
        try {
            personCultExpeList = personCultExpeDao.listPersonCultExpe(personCultExpe);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("培训经历信息列表获取失败" + e);
        }
        return personCultExpeList;
    }

    /*
    *@program: [personCultExpe]
    *@description: 新增人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:27
    */
    @Override
    public Integer insertPersonCultExpe(PersonCultExpeDO personCultExpe) {
        Integer num = 0;
        try {
            num = personCultExpeDao.insertPersonCultExpe(personCultExpe);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("培训经历信息对象新增失败" + e);
        }
        return num;
    }

    /*
    *@program: [personCultExpe]
    *@description: 更新人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:28
    */
    @Override
    public Integer updatePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        Integer num = 0;
        try {
            num = personCultExpeDao.updatePersonCultExpe(personCultExpe);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("培训经历信息对象修改失败" + e);
        }
        return num;
    }

    /*
    *@program: [personCultExpe]
    *@description: 删除人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:28
    */
    @Override
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe) {
        Integer num = 0;
        try {
            num =  personCultExpeDao.deletePersonCultExpe(personCultExpe);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("培训经历信息对象删除失败" + e);
        }
        return num;
    }

    /*
    *@program: [personCultExpe]
    *@description: 根据主键获取人员培训经历
    *@return: com.ccicnavi.bims.resource.pojo.PersonCultExpeDO
    *@author: XiaWei
    *@create: 2018/11/16 18:06
    */
    @Override
    public PersonCultExpeDO getPersonCultExpe(PersonCultExpeDO personCultExpe) {
        PersonCultExpeDO personCultExpeDO = null;
        try {
            personCultExpeDO =  personCultExpeDao.getPersonCultExpe(personCultExpe);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("培训经历信息对象获取失败" + e);
        }
        return personCultExpeDO;
    }

    /*
    *@program: [pageParameter]
    *@description: 根据条件 查询人员培训经历分页数据
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<PersonDO>
    *@author: XiaWei
    *@create: 2018/11/16 17:42
    */
    @Override
    public PageBean<PersonCultExpeDO> getPagePersonCultExpe(PageParameter<PersonCultExpeDO> pageParameter) {
        PageBean<PersonCultExpeDO> personCultExpeDOS = null;
        try {
            personCultExpeDOS =  personCultExpeDao.getPagePersonCultExpe(pageParameter);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("培训经历信息分页数据获取失败" + e);
        }
        return personCultExpeDOS;
    }
}
