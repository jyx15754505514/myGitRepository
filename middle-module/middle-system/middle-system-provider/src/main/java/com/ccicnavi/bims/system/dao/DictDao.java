package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/20 09:19
 * @Description:
 */
public interface DictDao {
    /**查询字典类型列表*/
    List<DictTypeDO> listDictType(List<String> types) throws Exception;
    /**查询字典值列表*/
    List<DictValueDO> listDictValue(List<String> types) throws Exception;
}
