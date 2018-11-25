package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 数据字典数值
 *@author: zhangxingbiao
 *@create: 2018-11-20 11:04
 */
public interface DictValueDao {
    /**
    *@Description: 新增数据字典数值
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    public Integer insertDictValue(DictTypeDTO dictTypeDTO);

    /**
    *@Description: 删除数据字典数值
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    public Integer deleteDictValue(DictTypeDTO dictTypeDTO);

    /**
    *@Description: 更改数据字典数值
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    public Integer updateDictValue(DictTypeDTO dictTypeDTO);


}
