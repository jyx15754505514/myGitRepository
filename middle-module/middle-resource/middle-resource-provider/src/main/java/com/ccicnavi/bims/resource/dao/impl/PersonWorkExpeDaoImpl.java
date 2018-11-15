package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.PersonWorkExpeDao;
import com.ccicnavi.bims.resource.pojo.PersonWorkExpeDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonWorkExpeDaoImpl implements PersonWorkExpeDao {
    /**
     *查询人员工作经历
     */
    @Override
    public List<PersonWorkExpeDO> listPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO){
        return new Eql().select("listPersonWorkExpeDO").params(personWorkExpeDO).returnType(PersonWorkExpeDO.class).execute();
    }

    /**
     *新增人员工作经历
     */
    @Override
    public Integer insertPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) {
        return new Eql().insert("insertPersonWorkExpeDO").params(personWorkExpeDO).returnType(Integer.class).execute();
    }

    /**
     *更改人员工作经历
     */
    @Override
    public Integer updatePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) {
        return new Eql().insert("updatePersonWorkExpeDO").params(personWorkExpeDO).returnType(Integer.class).execute();
    }

    /**
     *删除人员工作经历
     */
    @Override
    public Integer deletePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) {
        return new Eql().insert("deletePersonWorkExpeDO").params(personWorkExpeDO).returnType(Integer.class).execute();
    }

    /**
     *根据主键查询人员工作经历
     */
    @Override
    public PersonWorkExpeDO getPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) {
        return new Eql().selectFirst("getPersonWorkExpeDO").params(personWorkExpeDO).returnType(PersonWorkExpeDO.class).execute();
    }
}
