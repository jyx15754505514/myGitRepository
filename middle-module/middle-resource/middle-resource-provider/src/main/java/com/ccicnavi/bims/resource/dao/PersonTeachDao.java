package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
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
     List<PersonTeachDO> listPersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 添加人员
     * @param PersonTeachDo
     * @return Integer
     * @throws Exception
     */
     Integer insertPersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 更新人员
     * @param PersonTeachDo
     * @return Integer
     * @throws Exception
     */
     Integer updatePersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 删除人员
     * @param PersonTeachDo
     * @return Integer
     * @throws Exception
     */
     Integer deletePersonTeach(PersonTeachDO PersonTeachDo) throws Exception;

    /**
     * 根据uuid  查询人员信息
     * @param PersonTeachDo
     * @return PersonTeachDO
     */
     PersonTeachDO getPersonTeach(PersonTeachDO PersonTeachDo);

    /*
    *@Param: [pageParameter]
    *@description: 根据条件 查询人员教育分页信息
    *@return: com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.PersonTeachDO>
    *@author: WangGengXiang
    *@create: 2018/11/16 16:17
    */
      PageBean<PersonTeachDO> getPgaePersonTeach(PageParameter<PersonTeachDO> pageParameter);
}
