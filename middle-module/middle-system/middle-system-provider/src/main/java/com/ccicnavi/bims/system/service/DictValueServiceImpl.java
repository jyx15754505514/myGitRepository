package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.DictValueDao;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import com.ccicnavi.bims.system.service.api.DictValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典数值
 * @author: zhangxingbiao
 * @create: 2018-11-20 15:53
 */
@Service
@Slf4j
public class DictValueServiceImpl implements DictValueService {

    @Autowired
    private DictValueDao dictValueDao;

    /**
     * @Description: 新增数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer insertDictValue(DictValueDO dictValueDO) {
        try {
            return dictValueDao.insertDictValue(dictValueDO);
        } catch (Exception e) {
            log.error("新增数据字典数值失败", e);
            return 0;
        }
    }

    /**
     * @Description: 删除数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer deleteDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return dictValueDao.deleteDictValue(dictTypeDTO);
        } catch (Exception e) {
            log.error("删除数据字典数值失败", e);
            return null;
        }
    }

    /**
     * @Description: 更改数据字典数值
     * @Param: [dictTypeDTO]
     * @return: java.lang.Integer
     * @Author: zhangxingbiao
     * @date: 2018/11/24
     */
    @Override
    public Integer updateDictValue(DictValueDO dictValueDO) {
        try {
            return dictValueDao.updateDictValue(dictValueDO);
        } catch (Exception e) {
            log.error("删除数据字典数值失败", e);
            return null;
        }
    }

    /**
     * @program: bims-backend
     * @description: 根据字典类别编号查询字典信息
     * @author: zhangxingbiao
     * @create: 2018-11-20 10:41
     */
    @Override
    public List<DictValueDO> listDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return  dictValueDao.listDictValue(dictTypeDTO);
        } catch (Exception e) {
            log.error("根据字典类别编号查询字典信息失败", e);
            return null;
        }
    }

    /**
     * 根据主键获取对应数据字典数值信息
     * @param dictValueDO
     * @return
     */
    @Override
    public DictValueDO getDictValue(DictValueDO dictValueDO) {
        try {
            return dictValueDao.getDictValue(dictValueDO);
        } catch (Exception e) {
            log.error("根据主键获取对应数据字典数值信息失败", e);
            return null;
        }
    }
}
