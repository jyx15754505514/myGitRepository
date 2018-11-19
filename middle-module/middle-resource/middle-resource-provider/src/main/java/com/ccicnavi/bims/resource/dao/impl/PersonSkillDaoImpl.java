package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.PersonSkillDao;
import com.ccicnavi.bims.resource.pojo.PersonSkillDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonSkillDaoImpl implements PersonSkillDao {
    /**
     * 列表查询（职称信息）
     */
    @Override
    public List<PersonSkillDO> listPersonSkill(PersonSkillDO personSkillDO) throws  Exception{
        return new Eql().select("listPersonSkill").params(personSkillDO).returnType(PersonSkillDO.class).execute();
    }

    /**
     * 新增（职称信息）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public Integer insertPersonSkill(PersonSkillDO personSkillDO) throws  Exception {
        return new Eql().insert("insertPersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 更新（职称信息）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public Integer updatePersonSkill(PersonSkillDO personSkillDO) throws  Exception {
        return new Eql().update("updatePersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 删除（职称信息）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public Integer deletePersonSkill(PersonSkillDO personSkillDO) throws  Exception  {
        return new Eql().delete("deletePersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键或者名称获取（职称信息）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public PersonSkillDO getPersonSkill(PersonSkillDO personSkillDO) throws  Exception {
        return new Eql().selectFirst("getPersonSkill").params(personSkillDO).returnType(PersonSkillDO.class).execute();
    }


}
