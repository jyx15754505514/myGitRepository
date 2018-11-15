package com.ccicnavi.bims.resource.dao.impl;


import com.ccicnavi.bims.resource.dao.PersonWorkDao;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonWorkDaoImpl implements PersonWorkDao {
    /**
     * 查询人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public List<PersonWorkDO> listPersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().select("listPersonWorkDO").params(personWorkDO).returnType(PersonWorkDO.class).execute();
    }

    /**
     * 新增人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public Integer insertPersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().insert("insertPersonWorkDO").params(personWorkDO).returnType(Integer.class).execute();
    }

    /**
     * 更新人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public Integer updatePersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().insert("updatePersonWorkDO").params(personWorkDO).returnType(Integer.class).execute();
    }

    /**
     * 删除人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public Integer deletePersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().insert("deletePersonWorkDO").params(personWorkDO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询人员工作
     * @param
     * @return List<Template>
     * @throws Exception
     */
    @Override
    public PersonWorkDO getPersonWorkDO(PersonWorkDO personWorkDO){
        return new Eql().selectFirst("getPersonWorkDO").params(personWorkDO).returnType(PersonWorkDO.class).execute();
    }
}
