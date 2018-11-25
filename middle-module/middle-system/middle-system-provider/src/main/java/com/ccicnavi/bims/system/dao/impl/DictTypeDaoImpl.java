package com.ccicnavi.bims.system.dao.impl;


import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DictTypeDao;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 数据字典类型
 *@author: zhangxingbiao
 *@create: 2018-11-20 11:06
 */
@Service
@Slf4j
public class DictTypeDaoImpl implements DictTypeDao {

    /**
    *@Description: 新增数据字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer insertDictType(DictTypeDTO dictTypeDTO) {
        return new Eql("DEFAULT").insert("insertDictType").params(dictTypeDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 删除数据字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer deleteDictType(DictTypeDTO dictTypeDTO) {
        return new Eql("DEFAULT").delete("deleteDictType").params(dictTypeDTO).returnType(Integer.class).execute();
    }

    /**
    *@Description: 更改数据字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer updateDictType(DictTypeDTO dictTypeDTO) {
        return new Eql("DEFAULT").update("updateDictType").params(dictTypeDTO).returnType(Integer.class).execute();
    }
}
