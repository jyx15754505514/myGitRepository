package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.EquipService;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import com.ccicnavi.bims.resource.pojo.EquipDTO;
import org.springframework.web.bind.annotation.*;

import java.net.PortUnreachableException;
import java.util.Date;


@RestController
@RequestMapping("/equipLedger")
public class EquipmentLedgerController {

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    EquipService equipService;

    /*
     *@Param: [pageParameter]
     *@description: 根据条件查询 设备台账列表信息
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/24 10:02
     */
    @RequestMapping(value = "/listEquipLedger", method = RequestMethod.POST, produces = "application/json;charset:UTF-8")
    public ResultT listEquip(@RequestBody PageParameter<EquipDTO> pageParameter) {
        try {
            PageBean<EquipDO> equipDOPageBean = equipService.listEquip(pageParameter);
            return ResultT.success(equipDOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
     *@Param: [equipDO]
     *@description: 添加设备台账
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/24 10:55
     */
    @RequestMapping(value = "/addEquipLedger", method = RequestMethod.POST, produces = "application/json;charset:UTF-8")
    public ResultT addEquip(@RequestBody EquipDO equipDO) {
        String name = equipDO.getEquipName();
        Date testDate = equipDO.getTestDate();
        Date testValidDate = equipDO.getTestValidDate();
        //验证 设备名称 设备检/校日期  设备有效日期 非空判断
        if (name == null || name.equals("") || testDate == null || testDate.equals("") || testValidDate == null || testValidDate.equals("")) {
            return ResultT.failure(ResultCode.REQUIRED_FIELDS_IS_NULL);
        }
        try {
            Integer isSuccess = equipService.insertEquip(equipDO);
            if (isSuccess > 0) {
                return ResultT.success(isSuccess);
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /*
     *@Param: [equipDO]
     *@description: 更新台账信息
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/24 11:36
     */
    @RequestMapping(value = "/updateEquipLedger", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateEquip(@RequestBody EquipDO equipDO) {
        String name = equipDO.getEquipName();
        Date testDate = equipDO.getTestDate();
        Date testValidDate = equipDO.getTestValidDate();
        //验证 设备名称 设备检/校日期  设备有效日期  非空判断
        if (name == null || name.equals("") || testDate == null || testDate.equals("") || testValidDate == null || testValidDate.equals("")) {
            return ResultT.failure(ResultCode.REQUIRED_FIELDS_IS_NULL);
        }
        try {
            Integer isSuccess = equipService.updateEquip(equipDO);
            if (isSuccess > 0) {
                return ResultT.success(isSuccess);
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /*
     *@Param: [equipDTO]
     *@description: 删除设备台账  (待修改)
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/24 11:42
     */
    @RequestMapping(value = "/deleteEquipLedger", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteEquip(@RequestBody EquipDTO equipDTO) {
        try {
            Integer isSuccess = equipService.deleteEquip(equipDTO);
            if (isSuccess > 0) {
                return ResultT.success(isSuccess);
            } else {
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }

    /*
    *@Param: [equipDO]
    *@description: 根据设备uuid 获取设备详情信息、领用记录、检定记录
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/24 11:47
    */
    @RequestMapping(value = "/editEquipLedger", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT editEquip(@RequestBody EquipDTO equipDTO) {
        try {
            EquipDTO equipInfolist = equipService.getEquipInfolist(equipDTO);
            return ResultT.success(equipInfolist);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


}
