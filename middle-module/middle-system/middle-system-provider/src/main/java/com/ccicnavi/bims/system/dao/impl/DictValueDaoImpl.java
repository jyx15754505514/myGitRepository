package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.dao.DictTypeDao;
import com.ccicnavi.bims.system.dao.DictValueDao;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典数值
 * @author: zhangxingbiao
 * @create: 2018-11-20 11:06
 */
@Service
@Slf4j
public class DictValueDaoImpl implements DictValueDao {

    /**
     * @Description: 新增数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer insertDictValue(DictTypeDTO dictTypeDTO) throws Exception {
        return new Eql("DEFAULT").insert("insertDictValue").params(dictTypeDTO).returnType(Integer.class).execute();
    }

    /**
     * @Description: 删除数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer deleteDictValue(DictTypeDTO dictTypeDTO) throws Exception {
        return new Eql("DEFAULT").delete("insertDictValue").params(dictTypeDTO).returnType(Integer.class).execute();
    }

    /**
     * @Description: 更改数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer updateDictValue(DictTypeDTO dictTypeDTO) throws Exception {
        return new Eql("DEFAULT").update("insertDictValue").params(dictTypeDTO).returnType(Integer.class).execute();
    }

    /**
     * 查询字典值列表
     *
     * @return java.util.List<com.ccicnavi.bims.system.pojo.DictValueDO>
     * @author TXW
     * @date 2018/11/26 17:40
     * @params [dictParentUuid]
     */
    @Override
    public List<DictValueDO> listDictValue(String dictParentUuid) throws Exception {
        return new Eql("DEFAULT").select("listDictValue").params(dictParentUuid).returnType(DictValueDO.class).execute();
    }
}
