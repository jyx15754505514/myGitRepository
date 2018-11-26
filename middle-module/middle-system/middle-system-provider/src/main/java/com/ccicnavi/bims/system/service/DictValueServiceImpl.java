package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.DictValueDao;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import com.ccicnavi.bims.system.service.api.DictValueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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
    public Integer insertDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return dictValueDao.insertDictValue(dictTypeDTO);
        } catch (Exception e) {
            log.error("删除数据字典数值失败", e);
            return null;
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
    public Integer updateDictValue(DictTypeDTO dictTypeDTO) {
        try {
            return dictValueDao.updateDictValue(dictTypeDTO);
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
    public List<DictTypeDTO> listDictValue(DictTypeDTO dictTypeDTO) {
        List<DictTypeDTO> dictTypeList = null;
        List<String> dictType = dictTypeDTO.getTypeList();
        try {
            if (dictType != null && dictType.size() > 0) {
                dictTypeList = new ArrayList<>();
                for (String type : dictType) {
                    //查询子项封装成list
                    List<DictValueDO> dictValueList = dictValueDao.listDictValue(type);
                    DictTypeDTO dictTypeDTO1 = new DictTypeDTO();
                    dictTypeDTO1.setDictParentUuid(type);
                    dictTypeDTO1.setValueList(dictValueList);
                    dictTypeList.add(dictTypeDTO1);
                }
            }
        } catch (Exception e) {
            log.error("根据字典类别编号查询字典信息失败", e);
        }
        return dictTypeList;
    }
}
