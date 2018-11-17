package com.ccicnavi.bims.resource.dao;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.PersonWorkDO;

import java.util.List;

public interface PersonWorkDao {
    /**
     *查询人员工作信息
    */
    public List<PersonWorkDO> listPersonWorkDO(PersonWorkDO personWorkDO)throws Exception;

    /**
     *新增人员工作信息
    */
    public Integer insertPersonWorkDO(PersonWorkDO personWorkDO)throws Exception;

    /**
     *更改人员工作信息
    */
    public Integer updatePersonWorkDO(PersonWorkDO personWorkDO)throws Exception;

    /**
     *删除人员工作信息
    */
    public Integer deletePersonWorkDO(PersonWorkDO personWorkDO)throws Exception;

    /**
     *根据主键查询人员工作信息
    */
    public PersonWorkDO getPersonWorkDO(PersonWorkDO personWorkDO)throws Exception;

    /**
    *分页查询人员工作信息
    */
    public PageBean<PersonWorkDO> getPersonWorkPage(PageParameter<PersonWorkDO> pageParameter)throws Exception;


}
