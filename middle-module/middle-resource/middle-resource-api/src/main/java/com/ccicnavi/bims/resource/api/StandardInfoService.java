package com.ccicnavi.bims.resource.api;

import java.util.List;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;

public interface StandardInfoService {

    /**
     * 列表查询（标准）
     */
    public PageBean<StandardInfoDO> listStandardInfo(PageParameter pageParameter);

    /**
     * 新增（标准）
     */
    public Integer insertStandardInfo(StandardInfoDO standardInfoDO);

    /**
     * 修改（标准）
     */
    public Integer updateStandardInfo(StandardInfoDO standardInfoDO);

    /**
     * 删除（标准）
     */
    public Integer deleteStandardInfo(StandardInfoDO standardInfoDO);

    /**
     * 根据Id获取数据（标准）
     */
    public StandardInfoDO getStandardInfo(StandardInfoDO standardInfoDO);

}
