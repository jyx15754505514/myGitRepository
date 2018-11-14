package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.SealDO;
import java.util.List;

public interface SealService {

    /**
     * 列表查询（封识）
     */
    public List<SealDO> listSealDO(SealDO sealDO) ;

    /**
     * 新增（封识）
     */
    public Integer insertSealDO(SealDO sealDO) ;

    /**
     * 修改（封识）
     */
    public Integer updateSealDO(SealDO sealDO) ;

    /**
     * 删除（封识）
     */
    public Integer deleteSealDO(SealDO sealDO) ;

    /**
     * 根据Id获取数据（封识）
     */
    public SealDO getSealDO(SealDO sealDO) ;

}
