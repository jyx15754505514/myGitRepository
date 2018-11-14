package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.StandardInfoDO;

import java.util.List;

public interface StandardInfoDao {

    /**
     * 列表查询（标准）
     */
    public List<StandardInfoDO> listStandardInfoDO(StandardInfoDO standardInfoDO) ;

    /**
     * 新增（标准）
     */
    public Integer insertStandardInfoDO(StandardInfoDO standardInfoDO) ;

    /**
     * 修改（标准）
     */
    public Integer updateStandardInfoDO(StandardInfoDO standardInfoDO) ;

    /**
     * 删除（标准）
     */
    public Integer deleteStandardInfoDO(StandardInfoDO standardInfoDO) ;

    /**
     * 根据Id获取数据（标准）
     */
    public StandardInfoDO getStandardInfoDO(StandardInfoDO standardInfoDO) ;

}
