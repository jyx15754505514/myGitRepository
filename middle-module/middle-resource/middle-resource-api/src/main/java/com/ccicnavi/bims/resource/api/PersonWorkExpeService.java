package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.PersonWorkExpeDO;

import java.util.List;

public interface PersonWorkExpeService {
    /**
     *查询人员工作经历
     */
    public List<PersonWorkExpeDO> listPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO);

    /**
     *新增人员工作经历
     */
    public Integer insertPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO);

    /**
     *更改人员工作经历
     */
    public Integer updatePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO);

    /**
     *删除人员工作经历
     */
    public Integer deletePersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO);

    /**
     *根据主键查询人员工作经历
     */
    public PersonWorkExpeDO getPersonWorkExpeDO(PersonWorkExpeDO personWorkExpeDO);

    /**
     *分页查询人员工作经历
     */
    public PageBean<PersonWorkExpeDO> getPersonWorkExpePage(PageParameter<PersonWorkExpeDO> pageParameter);
}
