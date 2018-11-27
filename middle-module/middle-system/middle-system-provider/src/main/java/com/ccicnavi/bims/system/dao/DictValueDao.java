package com.ccicnavi.bims.system.dao;

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
    public Integer insertDictValue(DictValueDO dictValueDO) throws Exception;

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
    public Integer updateDictValue(DictValueDO dictValueDO) throws Exception;

    /**
     * 根据字典类别UUID和所属机构和所属产品线查询对应的value值
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictValueDO>
     * @author TXW
     * @date 2018/11/26 17:38
     * @params [dictParentUuid]
     */
    List<DictValueDO> listDictValue(DictTypeDTO dictTypeDTO) throws Exception;


    /**
     * 根据主键获取对应数据字典数值信息
     * @param dictValueDO
     * @return
     */
    DictValueDO getDictValue(DictValueDO dictValueDO) throws Exception;
}
