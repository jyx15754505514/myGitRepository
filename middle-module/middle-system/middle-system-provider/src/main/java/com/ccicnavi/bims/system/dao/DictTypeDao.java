package com.ccicnavi.bims.system.dao;


import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 字典类型
 * @author: zhangxingbiao
 * @create: 2018-11-20 11:04
 */
public interface DictTypeDao {

    /**
     * 列表查询字典类型
     *
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictTypeDO>
     * @author TXW
     * @date 2018/11/26 18:34
     * @params [dictTypeDTO]
     */
    public List<DictTypeDO> listDictType(DictTypeDTO dictTypeDTO) throws Exception;

    /**
     * @Description: 新增字典类型
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer insertDictType(DictTypeDTO dictTypeDTO) throws Exception;

    /**
     * @Description: 删除字典类型
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer deleteDictType(DictTypeDTO dictTypeDTO) throws Exception;

    /**
     * @Description: 更改字典类型
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer updateDictType(DictTypeDTO dictTypeDTO) throws Exception;
}
