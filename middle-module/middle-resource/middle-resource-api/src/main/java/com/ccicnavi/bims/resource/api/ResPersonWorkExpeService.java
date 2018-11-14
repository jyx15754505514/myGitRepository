package com.ccicnavi.bims.resource.api;


import com.ccicnavi.bims.resource.pojo.ResPersonWorkExpeDO;

import java.util.List;

public interface ResPersonWorkExpeService {
    /**
     *查询人员工作经历
     */
    public List<ResPersonWorkExpeDO> listResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception;

    /**
     *新增人员工作经历
     */
    public Integer insertResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception;

    /**
     *更改人员工作经历
     */
    public Integer updateResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception;

    /**
     *删除人员工作经历
     */
    public Integer deleteResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception;

    /**
     *根据主键查询人员工作经历
     */
    public ResPersonWorkExpeDO getResPersonWorkExpeDO(ResPersonWorkExpeDO resPersonWorkExpeDO) throws Exception;
}
