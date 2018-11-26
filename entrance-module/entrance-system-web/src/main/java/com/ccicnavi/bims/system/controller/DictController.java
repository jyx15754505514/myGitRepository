package com.ccicnavi.bims.system.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
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

    @Reference
    private DictService dictService;

    @Reference
    private DictTypeService dictTypeService;
    /**
    *@Description: 根据字典类别编号查询字典信息
    *@Param: [dictTypeDTO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/20
    */

    @RequestMapping(value = "/listDictValue", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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

    /**
    *@Description: 新增字典类型
    *@Param: [dictTypeDTO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @RequestMapping(value = "/insertDictType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertDictType(@RequestBody DictTypeDTO dictTypeDTO ) {
        Integer integer = null;
            try {
                integer = dictTypeService.insertDictType(dictTypeDTO);
                return ResultT.success();
            } catch (Exception e) {
                log.error("新增字典类型失败", e);
            }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
    *@Description: 修改字典类型
    *@Param: [dictTypeDTO]
    *@return: com.ccicnavi.bims.common.ResultT
    *@Author: zhangxingbiao
    *@date: 2018/11/24
    */
    @RequestMapping(value = "/updateDictType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateDictType(@RequestBody DictTypeDTO dictTypeDTO ) {
        Integer integer = null;
        try {
            integer = dictTypeService.updateDictType(dictTypeDTO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("修改字典类型失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }
    /**
     *@Description: 删除字典类型
     *@Param: [dictTypeDTO]
     *@return: com.ccicnavi.bims.common.ResultT
     *@Author: zhangxingbiao
     *@date: 2018/11/24
     */
    @RequestMapping(value = "/deleteDictType", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteDictType(@RequestBody DictTypeDTO dictTypeDTO ) {
        Integer integer = null;
        try {
            integer = dictTypeService.deleteDictType(dictTypeDTO);
            return ResultT.success();
        } catch (Exception e) {
            log.error("删除字典类型失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

}
