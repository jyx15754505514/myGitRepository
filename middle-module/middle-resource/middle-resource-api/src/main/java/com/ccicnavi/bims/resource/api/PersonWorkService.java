package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;

import java.util.List;

public interface PersonWorkService {
    /**
     *查询人员工作信息
    */
    public List<PersonWorkDO> listPersonWorkDO(PersonWorkDO personWorkDO);

    /**
     *新增人员工作信息
    */
    public Integer insertPersonWorkDO(PersonWorkDO personWorkDO);

    /**
     *更改人员工作信息
    */
    public Integer updatePersonWorkDO(PersonWorkDO personWorkDO);

    /**
     *删除人员工作信息
    */
    public Integer deletePersonWorkDO(PersonWorkDO personWorkDO);

    /**
     *根据主键查询人员工作信息
    */
    public PersonWorkDO getPersonWorkDO(PersonWorkDO personWorkDO);

    /**
     *分页查询人员工作信息
     */
    public PageBean<PersonWorkDO> getPersonWorkPage(PageParameter<PersonWorkDO> pageParameter);
}
