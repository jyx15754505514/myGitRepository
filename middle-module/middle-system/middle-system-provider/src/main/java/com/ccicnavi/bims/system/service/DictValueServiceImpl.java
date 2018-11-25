package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.DictValueDao;
import com.ccicnavi.bims.system.dao.impl.DictTypeDaoImpl;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import com.ccicnavi.bims.system.service.api.DictValueService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *@program: bims-backend
 *@description: 数据字典数值
 *@author: zhangxingbiao
 *@create: 2018-11-20 15:53
 */
@Service
@Slf4j
public class DictValueServiceImpl implements DictValueService {

    @Autowired
    private DictValueDao dictValueDao;

    /**
    *@Description: 新增数据字典数值
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer insertDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return dictValueDao.insertDictValue(dictTypeDTO);
        } catch (Exception e) {
            log.error("删除数据字典数值失败",e);
            return null;
        }
    }

    /**
    *@Description: 删除数据字典数值
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer deleteDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return dictValueDao.deleteDictValue(dictTypeDTO);
        } catch (Exception e) {
            log.error("删除数据字典数值失败",e);
            return null;
        }
    }

    /**
    *@Description: 更改数据字典数值
    *@Param: [dictTypeDTO]
    *@return: java.lang.Integer
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @Override
    public Integer updateDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return dictValueDao.updateDictValue(dictTypeDTO);
        } catch (Exception e) {
            log.error("删除数据字典数值失败",e);
            return null;
        }
    }
}
