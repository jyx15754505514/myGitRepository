package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.PersonDO;


import java.util.List;

public interface PersonService {

    /**
     * 查询人员
     * @param personDo
     * @return List<PersonDO>
     * @throws Exception
     */
    public List<PersonDO> listPerson(PersonDO personDo) throws Exception;

    /**
     * 添加人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    public Integer insertPerson(PersonDO personDo) throws Exception;

    /**
     * 更新人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    public Integer updatePerson(PersonDO personDo) throws Exception;

    /**
     * 删除人员
     * @param personDo
     * @return Integer
     * @throws Exception
     */
    public Integer deletePerson(PersonDO personDo) throws Exception;

    /**
     * 根据uuid  查询人员信息
     * @param personDo
     * @return PersonDO
     */
    public PersonDO getPerson(PersonDO personDo);


}
