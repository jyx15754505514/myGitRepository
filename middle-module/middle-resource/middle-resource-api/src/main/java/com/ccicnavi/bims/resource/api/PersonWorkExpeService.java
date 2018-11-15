package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.resource.pojo.PersonWorkExpeDO;

import java.util.List;

public interface PersonWorkExpeService {
    /**
     *查询人员工作经历
     */
    public List<PersonWorkExpeDO> listPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception;

    /**
     *新增人员工作经历
     */
    public Integer insertPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception;

    /**
     *更改人员工作经历
     */
    public Integer updatePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception;

    /**
     *删除人员工作经历
     */
    public Integer deletePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception;

    /**
     *根据主键查询人员工作经历
     */
    public PersonWorkExpeDO getPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO) throws Exception;
}
