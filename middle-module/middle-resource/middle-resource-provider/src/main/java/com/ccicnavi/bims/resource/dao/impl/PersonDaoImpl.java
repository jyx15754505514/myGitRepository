package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.pojo.PersonDO;
import com.ccicnavi.bims.resource.dao.PersonDao;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonDaoImpl  implements PersonDao {

    Eql eql = new Eql();

    /**
     * 查询人员信息
     * @param personDo
     * @return List<PersonDO>
     * @throws Exception
     */
    @Override
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception {

        return eql.select("listPerson").params(personDo).returnType(PersonDO.class).execute();
    }

    /**
     * 添加人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPerson(PersonDO personDo) throws Exception {
        return eql.select("insertPerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 更新人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePerson(PersonDO personDo) throws Exception {
        return eql.select("updatePerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 删除人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePerson(PersonDO personDo) throws Exception {
        return eql.select("deletePerson").params(personDo).returnType(Integer.class).execute();
    }

    /**
     * 根据主键查询人员信息
     * @param personDo
     * @return PersonDO
     * @throws Exception
     */
    @Override
    public PersonDO getPerson(PersonDO personDo) {
        return new Eql().select("getPerson").params(personDo).returnType(PersonDO.class).execute();
    }


    public static void main(String[] args) {
        List<Map<String, Object>> map = new Eql().select("listPerson").execute();
        System.out.print(map);
    }
}
