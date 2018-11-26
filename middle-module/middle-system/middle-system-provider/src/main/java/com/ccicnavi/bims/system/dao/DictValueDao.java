package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典数值
 * @author: zhangxingbiao
 * @create: 2018-11-20 11:04
 */
public interface DictValueDao {
    /**
     * @Description: 新增数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer insertDictValue(DictTypeDTO dictTypeDTO) throws Exception;

    /**
     * @Description: 删除数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer deleteDictValue(DictTypeDTO dictTypeDTO) throws Exception;

    /**
     * @Description: 更改数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer updateDictValue(DictTypeDTO dictTypeDTO) throws Exception;

    /**
     * 查询字典值列表
     *
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictValueDO>
     * @author TXW
     * @date 2018/11/26 17:38
     * @params [dictParentUuid]
     */
    List<DictValueDO> listDictValue(String dictParentUuid) throws Exception;


}
