package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.PersonTeachDO;

import java.util.List;

public interface PersonTeachDao {
    /**
     * 查询人员
     *
     * @param PersonTeachDo
     * @return List<PersonTeachDO>
     * @throws Exception
     */
    public List<PersonTeachDO> listPersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 添加人员
     * @param PersonTeachDo
     * @return Integer
     * @throws Exception
     */
    public Integer insertPersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 更新人员
     * @param PersonTeachDo
     * @return Integer
     * @throws Exception
     */
    public Integer updatePersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 删除人员
     * @param PersonTeachDo
     * @return Integer
     * @throws Exception
     */
    public Integer deletePersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 根据uuid  查询人员信息
     * @param PersonTeachDo
     * @return PersonTeachDO
     */
    public PersonTeachDO getPersonTeach(PersonTeachDO PersonTeachDo);
}
