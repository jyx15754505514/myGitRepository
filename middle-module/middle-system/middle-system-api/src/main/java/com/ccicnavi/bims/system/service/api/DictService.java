package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.DictTypeDTO;

import java.util.List;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/19 22:46
 * @Description:
 */
public interface DictService {

    /**
    *@Description: 根据字典类别编号查询字典信息
    *@Param: [dictType]
    *@return: java.util.List<DictTypeDTO>
    *@Author: zhangxingbiao
    *@date: 2018/11/20
    */

    public List<DictTypeDTO> listDictValue(List<String> dictType);



}
