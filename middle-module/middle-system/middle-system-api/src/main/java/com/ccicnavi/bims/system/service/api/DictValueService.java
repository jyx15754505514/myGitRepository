package com.ccicnavi.bims.system.service.api;


import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典数值api接口
 * @author: zhangxingbiao
 * @create: 2018-11-20 15:42
 */
public interface DictValueService {

    /**
     * @Description: 新增数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer insertDictValue(DictValueDO dictValueDO);

    /**
     * @Description: 删除数据字典数值
     * @Param: [dictTypeDO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer deleteDictValue(DictTypeDTO dictTypeDO);

    /**
     * @Description: 更改数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer updateDictValue(DictValueDO dictValueDO);

    /**
     * 根据字典类别编号查询字典信息
     *
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictTypeDTO>
     * @author TXW
     * @date 2018/11/26 17:33
     * @params [dictType]
     */
    public List<DictValueDO> listDictValue(DictTypeDTO dictTypeDTO);

}
