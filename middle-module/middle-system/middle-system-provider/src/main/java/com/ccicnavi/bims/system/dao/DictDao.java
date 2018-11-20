package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.AreaDO;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典的Dao层接口
 * @author: zhangxingbiao
 * @create: 2018-11-20 10:41
 */

public interface DictDao {

    /**
    *@Description: 查询字典值列表
    *@Param: [dictParentUuid]
    *@return: java.util.List<com.ccicnavi.bims.system.pojo.DictValueDO>
    *@Author: zhangxingbiao
    *@date: 2018/11/20
    */
    List<DictValueDO> listDictValue(String dictParentUuid) throws Exception;
}
