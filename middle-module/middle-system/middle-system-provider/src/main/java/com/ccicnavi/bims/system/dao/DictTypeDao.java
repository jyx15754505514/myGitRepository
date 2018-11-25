package com.ccicnavi.bims.system.dao;


import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 字典类型
 *@author: zhangxingbiao
 *@create: 2018-11-20 11:04
 */
public interface DictTypeDao {

    /**
    *@Description: 新增字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    public Integer insertDictType(DictTypeDTO dictTypeDTO);

    /**
    *@Description: 删除字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    public Integer deleteDictType(DictTypeDTO dictTypeDTO);

    /**
    *@Description: 更改字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    public Integer updateDictType(DictTypeDTO dictTypeDTO);
}
