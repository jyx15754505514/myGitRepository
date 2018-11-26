package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;

import java.util.List;


/**
 * @program: bims-backend
 * @description: 数据字典类型的api接口
 * @author: zhangxingbiao
 * @create: 2018-11-20 10:54
 */
public interface DictTypeService {

    /**
     * 列表查询字典类型
     *
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictTypeDO>
     * @author TXW
     * @date 2018/11/26 20:02
     * @params [dictTypeDTO]
     */
    public List<DictTypeDO> listDictType(DictTypeDTO dictTypeDTO);

    /**
     * @Description: 新增数据字典类型
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer insertDictType(DictTypeDTO dictTypeDTO);

    /**
     * @Description: 删除数据字典类型
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer deleteDictType(DictTypeDTO dictTypeDTO);

    /**
     * @Description: 更改字典类型
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    public Integer updateDictType(DictTypeDTO dictTypeDTO);
}
