package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.resource.api.PersonService;
import com.ccicnavi.bims.resource.dao.PersonDao;
import com.ccicnavi.bims.resource.pojo.PersonDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;


    /**
     * 查询人员信息
     * @param personDo
     * @return List<PersonDO>
     * @throws Exception
     */
    @Override
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception {
        return personDao.listPerson(personDo);
    }

    /**
     * 添加人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer insertPerson(PersonDO personDo) throws Exception {
        return personDao.insertPerson(personDo);
    }

    /**
     * 更新人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer updatePerson(PersonDO personDo) throws Exception {
        return personDao.updatePerson(personDo);
    }

    /**
     * 删除人员信息
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer deletePerson(PersonDO personDo) throws Exception {
        return personDao.deletePerson(personDo);
    }

    /**
     * 根据主键查询人员信息
     * @param personUuid
     * @return PersonDO
     * @throws Exception
     */
    @Override
    public PersonDO getPerson(PersonDO personDo) {
        return personDao.getPerson(personDo);
    }
}
