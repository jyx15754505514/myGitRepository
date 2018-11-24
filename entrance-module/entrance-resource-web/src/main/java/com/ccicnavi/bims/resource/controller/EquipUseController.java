package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipUseService;
import com.ccicnavi.bims.resource.pojo.EquipUseDO;
import com.ccicnavi.bims.resource.pojo.EquipUseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/equipUse")
public class EquipUseController {

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20882")
    EquipUseService equipUseService;


    /**
     * 分页查询设备领用归还信息
     * @author TXW
     * @date 2018/11/24 17:44
     * @params [pageParameter]
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/listEquipUse", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listEquipUse(@RequestBody PageParameter<EquipUseDO> pageParameter) {
        try {
            PageBean<EquipUseDO> equipUseDOS = equipUseService.listEquipUse(pageParameter);
            return ResultT.success(equipUseDOS);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


    /**
     * 新增设备领用归还信息
     * @author TXW
     * @date 2018/11/24 17:43
     * @params [equipUseDO]
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/insertEquipUse", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertEquipUse(@RequestBody EquipUseDO equipUseDO) {
        try {
            Integer num = equipUseService.insertEquipUse(equipUseDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }

    }

    /**
     * 更新设备领用归还信息
     * @author TXW
     * @date 2018/11/24 17:44
     * @params [equipUseDO]
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateEquipUse", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateEquipUse(@RequestBody EquipUseDO equipUseDO) {
        try {
            Integer num = equipUseService.updateEquipUse(equipUseDO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * 根据设备领用归还信息主键删除设备领用归还信息
     * @author TXW
     * @date 2018/11/24 17:45
     * @params [equipUseDTO]
     * @return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/deleteEquipUse", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteEquipUse(@RequestBody EquipUseDTO equipUseDTO) {
        try {
            Integer num = equipUseService.deleteEquipUse(equipUseDTO);
            return ResultT.success(num);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

}
