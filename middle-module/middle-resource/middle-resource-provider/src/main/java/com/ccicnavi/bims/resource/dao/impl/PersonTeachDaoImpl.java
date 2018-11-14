package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.PersonTeachDao;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.pojo.PersonTeachDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonTeachDaoImpl implements PersonTeachDao {


    Eql eql  =  new Eql();

    @Override
    public List<PersonTeachDO> listPersonTeach(PersonTeachDO personTeachDO) throws Exception {
        return  eql.select("listPersonTeach").params(personTeachDO).returnType(PersonDO.class).execute();
    }

    @Override
    public Integer insertPersonTeach(PersonTeachDO personTeachDO) throws Exception {
        return eql.select("insertPerson").params(personTeachDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer updatePersonTeach(PersonTeachDO personTeachDO) throws Exception {
        return eql.select("updatePerson").params(personTeachDO).returnType(Integer.class).execute();
    }

    @Override
    public Integer deletePersonTeach(PersonTeachDO personTeachDO) throws Exception {
        return eql.select("deletePerson").params(personTeachDO).returnType(Integer.class).execute();
    }

    @Override
    public PersonTeachDO getPersonTeach(PersonTeachDO personTeachDO) {
        return new Eql().select("getPerson").params(personTeachDO).returnType(PersonDO.class).execute();
    }
}
