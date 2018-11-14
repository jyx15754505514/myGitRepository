package com.ccicnavi.bims.resource.api;

import java.util.List;
import com.ccicnavi.bims.resource.pojo.StandardInfoDO;

public interface StandardInfoService {

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
