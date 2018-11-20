package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.system.pojo.DictTypeDO;
import com.ccicnavi.bims.system.pojo.DictTypeDTO;
import com.ccicnavi.bims.system.service.api.DictService;
import com.ccicnavi.bims.system.service.api.DictTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *@program: bims-backend
 *@description: 数据字典
 *@author: zhangxingbiao
 *@create: 2018-11-20 16:03
 */
@RequestMapping(value = "/dict")
@RestController
public class DictController {

    private final static Logger log = LoggerFactory.getLogger(DictController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20881")
    private DictService dictService;

    /**
    *@Description: 根据字典类别编号查询字典信息
    *@Param: [dictTypeDTO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/20
    */

    @RequestMapping(value = "/listDict", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listDict(@RequestBody DictTypeDTO dictTypeDTO ) {
        if(!StringUtils.isEmpty(dictTypeDTO.getTypeList())) {
            try {
                List<String> typeList = dictTypeDTO.getTypeList();
                List<DictTypeDTO> dictTypeList = dictService.listDictValue(typeList);
                if(dictTypeList != null && !dictTypeList.isEmpty()) {
                    return ResultT.success(dictTypeList);
                }
            } catch (Exception e) {
                log.error("根据字典类别编号查询字典信息失败", e);
            }
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }
}
