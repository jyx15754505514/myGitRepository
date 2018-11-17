package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.SealDO;
import java.util.List;

public interface SealService {

    /**
     * 列表查询（封识）
     */
    public PageBean<SealDO> listSeal(PageParameter pageParameter);

    /**
     * 新增（封识）
     */
    public Integer insertSeal(SealDO sealDO);

    /**
     * 修改（封识）
     */
    public Integer updateSeal(SealDO sealDO);

    /**
     * 删除（封识）
     */
    public Integer deleteSeal(SealDO sealDO);

    /**
     * 根据Id获取数据（封识）
     */
    public SealDO getSeal(SealDO sealDO);

}
