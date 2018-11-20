package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.UserDO;

/**
 * @Auther: CongZhiYuan
 * @Date: 2018/11/19 22:46
 * @Description:
 */
public interface DictService {
    /**
     * 根据字典类别编号查询字典信息
     * @param types
     * @return ResultT
     */
    public ResultT getDictsByTypes(String types);
}
