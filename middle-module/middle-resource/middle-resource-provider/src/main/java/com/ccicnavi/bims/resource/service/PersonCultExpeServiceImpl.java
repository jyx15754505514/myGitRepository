package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.resource.api.PersonCultExpeService;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.resource.dao.PersonCultExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.n3r.eql.Eql;

import java.util.List;

@Service
public class PersonCultExpeServiceImpl implements PersonCultExpeService {

    @Autowired
    private PersonCultExpeDao PersonCultExpeDao;

    /*
    *@program: [personCultExpe]
    *@description: 查询人员培训经历
    *@return: java.util.List<com.ccicnavi.bims.resource.pojo.PersonCultExpeDO>
    *@author: XiaWei
    *@create: 2018/11/16 10:24
    */
    @Override
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.listPersonCultExpe(personCultExpe);
    }

    /*
    *@program: [personCultExpe]
    *@description: 新增人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:27
    */
    @Override
    public Integer insertPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.insertPersonCultExpe(personCultExpe);
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
        return PersonCultExpeDao.updatePersonCultExpe(personCultExpe);
    }

    /*
    *@program: [personCultExpe]
    *@description: 删除人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:28
    */
    @Override
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return PersonCultExpeDao.deletePersonCultExpe(personCultExpe);
    }
}
