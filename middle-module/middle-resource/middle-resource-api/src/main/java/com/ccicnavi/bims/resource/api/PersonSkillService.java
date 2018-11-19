package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.PersonSkillDO;

import java.util.List;

public interface PersonSkillService {
    /**
     * 查询职称信息
     * @param personSkillDO
     * @return
     */
    public List<PersonSkillDO> listPersonSkill(PersonSkillDO personSkillDO);

    /**
     * 根据主键查询职称信息
     * @param personSkillDO
     * @return
     */
    public PersonSkillDO getPersonSkill(PersonSkillDO personSkillDO);

    /**
     * 新增职称信息
     * @param personSkillDO
     * @return
     */
    public Integer insertPersonSkill(PersonSkillDO personSkillDO);

    /**
     * 修改职称信息
     * @param personSkillDO
     * @return
     */
    public Integer updatePersonSkill(PersonSkillDO personSkillDO);

    /**
     * 删除职称信息
     * @param personSkillDO
     * @return
     */
    public Integer deletePersonSkill(PersonSkillDO personSkillDO);


}
