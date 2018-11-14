package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.resource.pojo.ResPersonWorkDO;

import java.util.List;

public interface ResPersonWorkService {
    /**
     *查询人员工作信息
    */
    public List<ResPersonWorkDO> listResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception;

    /**
     *新增人员工作信息
    */
    public Integer insertResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception;

    /**
     *更改人员工作信息
    */
    public Integer updateResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception;

    /**
     *删除人员工作信息
    */
    public Integer deleteResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception;

    /**
     *根据主键查询人员工作信息
    */
    public ResPersonWorkDO getResPersonWorkDO(ResPersonWorkDO resPersonWorkDO) throws Exception;
}
