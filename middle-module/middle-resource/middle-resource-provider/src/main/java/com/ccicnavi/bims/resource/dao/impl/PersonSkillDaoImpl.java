package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.PersonSkillDao;
import com.ccicnavi.bims.resource.pojo.PersonSkillDO;
import org.n3r.eql.Eql;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonSkillDaoImpl implements PersonSkillDao {
    /**
     * 列表查询（标准）
     */
    @Override
    public List<PersonSkillDO> listPersonSkillDO(PersonSkillDO personSkillDO) throws  Exception{
        return EqlUtils.getInstance("DEFAULT").select("listPersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 新增（标准）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public Integer insertPersonSkillDO(PersonSkillDO personSkillDO) throws  Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertPersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 更新（标准）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public Integer updatePersonSkillDO(PersonSkillDO personSkillDO) throws  Exception {
        return EqlUtils.getInstance("DEFAULT").update("updatePersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 删除（标准）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public Integer deletePersonSkillDO(PersonSkillDO personSkillDO) throws  Exception  {
        return EqlUtils.getInstance("DEFAULT").update("deletePersonSkill").params(personSkillDO).returnType(Integer.class).execute();
    }

    /**
     * 根据主键或者名称获取（标准）
     * @param personSkillDO
     * @return
     * @
     */
    @Override
    public PersonSkillDO getPersonSkillDO(PersonSkillDO personSkillDO) throws  Exception {
        return EqlUtils.getInstance("DEFAULT").selectFirst("getPersonSkill").params(personSkillDO).returnType(PersonSkillDO.class).execute();
    }


}
