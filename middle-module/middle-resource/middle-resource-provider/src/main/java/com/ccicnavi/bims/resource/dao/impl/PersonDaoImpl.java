package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.dao.PersonDao;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDaoImpl  implements PersonDao {


    /**
     * 查询人员信息
     * @param personDo
     * @return List<PersonDO>
     * @throws Exception
     */
    @Override
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception {

        return new Eql().select("listPerson").params(personDo).returnType(PersonDO.class).execute();
    }

    /**
     * 添加人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPerson(PersonDO personDo) throws Exception {
        return new Eql().select("insertPerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 更新人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePerson(PersonDO personDo) throws Exception {
        return new Eql().select("updatePerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 删除人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePerson(PersonDO personDo) throws Exception {
        return new Eql().select("deletePerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询人员信息
     * @param personUuid
     * @return PersonDO
     * @throws Exception
     */
    @Override
    public PersonDO getPerson(PersonDO personDo) {
        return new Eql().select("getPerson").params(personDo).returnType(PersonDO.class).execute();
    }
}
