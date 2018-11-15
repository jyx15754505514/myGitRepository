package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.PersonSkillDO;

import java.util.List;

public interface PersonSkillService {
    /**
     * 查询职称信息
     * @param personSkillDO
     * @return
     */
    public List<PersonSkillDO> listPersonSkillDO(PersonSkillDO personSkillDO);

    /**
     * 根据主键查询职称信息
     * @param personSkillDO
     * @return
     */
    public PersonSkillDO getPersonSkillDO(PersonSkillDO personSkillDO);

    /**
     * 新增职称信息
     * @param personSkillDO
     * @return
     */
    public Integer insertPersonSkillDO(PersonSkillDO personSkillDO);

    /**
     * 修改职称信息
     * @param personSkillDO
     * @return
     */
    public Integer updatePersonSkillDO(PersonSkillDO personSkillDO);

    /**
     * 删除职称信息
     * @param personSkillDO
     * @return
     */
    public Integer deletePersonSkillDO(PersonSkillDO personSkillDO);


}
