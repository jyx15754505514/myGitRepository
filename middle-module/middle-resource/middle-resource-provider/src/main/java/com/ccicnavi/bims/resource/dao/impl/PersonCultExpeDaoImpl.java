package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.PersonCultExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonCultExpeDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonCultExpeDaoImpl implements PersonCultExpeDao {
    /*
    *@program: [personCultExpe]
    *@description: 查询人员培训经历
    *@return: java.util.List<com.ccicnavi.bims.resource.pojo.PersonCultExpeDO>
    *@author: XiaWei
    *@create: 2018/11/16 10:27
    */
    @Override
    public List<PersonCultExpeDO> listPersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return new Eql().select("listPersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
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
        return new Eql().insert("insertPersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
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
        return new Eql().insert("updatePersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
    }

    /*
    *@program: [personCultExpe]
    *@description: 删除人员培训经历
    *@return: java.lang.Integer
    *@author: XiaWei
    *@create: 2018/11/16 10:29
    */
    @Override
    public Integer deletePersonCultExpe(PersonCultExpeDO personCultExpe) throws Exception {
        return new Eql().insert("deletePersonCultExpe").params(personCultExpe).returnType(PersonCultExpeDO.class).execute();
    }
}
