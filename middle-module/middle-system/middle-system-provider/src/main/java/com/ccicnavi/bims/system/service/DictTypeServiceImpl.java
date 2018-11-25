package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.DictTypeDao;
import com.ccicnavi.bims.system.dao.impl.DictTypeDaoImpl;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.service.api.DictTypeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 数据字典的api实现类
 *@author: zhangxingbiao
 *@create: 2018-11-20 10:59
 */
@Service
@Slf4j
public class DictTypeServiceImpl implements DictTypeService {

    @Autowired
    private DictTypeDao dictTypeDao;

    /**
    *@Description: 新增字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */

    @Override
    public Integer insertDictType(DictTypeDTO dictTypeDTO) {
        try {
            return dictTypeDao.insertDictType(dictTypeDTO);
        } catch (Exception e) {
            log.error("新增字典类型失败",e);
            return null;
        }
    }

    /**
    *@Description: 删除字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer deleteDictType(DictTypeDTO dictTypeDTO) {
        try {
            return dictTypeDao.deleteDictType(dictTypeDTO);
        } catch (Exception e) {
            log.error("删除字典类型失败",e);
            return null;
        }
    }

    /**
    *@Description: 更改字典类型
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer updateDictType(DictTypeDTO dictTypeDTO) {
        try {
            return dictTypeDao.updateDictType(dictTypeDTO);
        } catch (Exception e) {
            log.error("更新字典类型失败",e);
            return null;
        }
    }
}

