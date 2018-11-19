package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.PersonSkillDO;

import java.util.List;

public interface PersonSkillDao {

    /**
     * 查询职称信息
     * @param personSkillDO
     * @return
     */
    public List<PersonSkillDO> listPersonSkill(PersonSkillDO personSkillDO) throws Exception;

    /**
     * 根据主键查询职称信息
     * @param personSkillDO
     * @return
     */
    public PersonSkillDO getPersonSkill(PersonSkillDO personSkillDO) throws Exception;

    /**
     * 新增职称信息
     * @param personSkillDO
     * @return
     */
    public Integer insertPersonSkill(PersonSkillDO personSkillDO) throws Exception;

    /**
     * 修改职称信息
     * @param personSkillDO
     * @return
     */
    public Integer updatePersonSkill(PersonSkillDO personSkillDO) throws Exception;

    /**
     * 删除职称信息
     * @param  personSkillDO
     * @return
     */
    public Integer deletePersonSkill(PersonSkillDO personSkillDO) throws Exception;
}
