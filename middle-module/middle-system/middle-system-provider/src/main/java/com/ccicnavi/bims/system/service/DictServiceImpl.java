package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.system.dao.DictDao;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.pojo.DictValueDO;
import com.ccicnavi.bims.system.service.api.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 数据字典的Service实现
 * @author: zhangxingbiao
 * @create: 2018-11-20 10:41
 */
@Service
@Slf4j
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;
    /**
     *@program: bims-backend
     *@description: 根据字典类别编号查询字典信息
     *@author: zhangxingbiao
     *@create: 2018-11-20 10:41
     */
    @Override
    public List<DictTypeDTO> listDictValue(List<String> dictType) {
        List<DictTypeDTO> dictTypeList = null;
        try {
            if(dictType != null && dictType.size() > 0) {
                dictTypeList = new ArrayList<>();
                for (String type : dictType) {
                    //查询子项封装成list
                    List<DictValueDO> dictValueList = dictDao.listDictValue(type);
                    DictTypeDTO dictTypeDTO = new DictTypeDTO();
                    dictTypeDTO.setDictParentUuid(type);
                    dictTypeDTO.setValueList(dictValueList);
                    dictTypeList.add(dictTypeDTO) ;
                }
            }
        } catch (Exception e) {
            log.error("根据字典类别编号查询字典信息失败", e);
        }
        return dictTypeList;
    }
}
