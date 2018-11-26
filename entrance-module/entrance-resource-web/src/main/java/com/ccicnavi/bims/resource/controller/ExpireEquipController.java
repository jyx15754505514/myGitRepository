package com.ccicnavi.bims.resource.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDO;
import com.ccicnavi.bims.product.pojo.StandardInfoDTO;
import com.ccicnavi.bims.resource.api.EquipService;
import com.ccicnavi.bims.resource.api.EquipTestService;
import com.ccicnavi.bims.resource.pojo.EquipDO;
import com.ccicnavi.bims.resource.pojo.EquipDTO;
import com.ccicnavi.bims.resource.pojo.EquipTestDO;
import com.ccicnavi.bims.resource.pojo.EquipTestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 设备管理
 * @author: ZhaoXu
 * @create: 2018-11-23 10:27
 */
@RestController
@RequestMapping(value = "/expire")
@Slf4j
public class ExpireEquipController {


   /* @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20882")
    EquipService equipService;*/

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20882")
    EquipTestService equipTestService;

 /**
     * @description 到期提醒查询
     * @param
     * @return com.ccicnavi.bims.common.ResultT
     * @author ZhaoXu
     *//*
    @RequestMapping(value = "/listExpireTypePage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT expireEquip(@RequestBody PageParameter<EquipDTO> pageParameter){
        try {
            PageBean<EquipDO> EquipList= equipService.expireEquip(pageParameter);
            return ResultT.success(EquipList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }*/

    /**
     * @description 设备检定列表
     * @param
     * @return com.ccicnavi.bims.common.ResultT
     * @author ZhaoXu
     */

    @RequestMapping(value = "listExpireTestTypePage",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listExpireTestTypePage(@RequestBody PageParameter<EquipTestDO> pageParameter){
        log.info("开始查询设备信息列表 Param: " + JSON.toJSONString(pageParameter) + " Time: " + new Date());
        try {
            PageBean<EquipTestDO> EquipTestList = equipTestService.listEquipTest(pageParameter);
            if (null == EquipTestList) {
                log.error("查询设备信息列表异常");
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
            log.info("查询设备信息列表结果: " + JSON.toJSONString(EquipTestList));
            return ResultT.success(EquipTestList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询设备信息列表异常");
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
     * @description 设备检定新增
     * @param
     * @return com.ccicnavi.bims.common.ResultT
     * @author ZhaoXu
     */

    @RequestMapping(value = "saveEquipTest",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveEquipTest(@RequestBody EquipTestDO equipTestDO){
        log.info("开始保存设备检定信息 Param: " + JSON.toJSONString(equipTestDO) + " Time: " + new Date());
        try {
            Integer count = equipTestService.insertEquipTest(equipTestDO);
            if (count > 0) {
                log.info("保存设备检定结果: " + "新增数据条数 " + count);
                return ResultT.success("保存数据成功");
            } else {
                log.error("保存设备检定信息异常");
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存设备检定信息异常");
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * @description 更新设备检定
     * @param
     * @return com.ccicnavi.bims.common.ResultT
     * @author ZhaoXu
     */
    @RequestMapping(value = "/updateEquipTest",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateEquipTest(@RequestBody EquipTestDO equipTestDO){
        try {
            Integer EquipTestList= equipTestService.updateEquipTest(equipTestDO);
            return ResultT.success(EquipTestList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * @description 根据设备检定主键删除设备检定
     * @param
     * @return com.ccicnavi.bims.common.ResultT
     * @author ZhaoXu
     */
    @RequestMapping(value = "deleteEquipTest",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteEquipTest(@RequestBody EquipTestDTO equipTestDTO){
        log.info("开始移除设备检定信息 Param: " + JSON.toJSONString(equipTestDTO) + " Time: " + new Date());
        try {
            Integer count = equipTestService.deleteEquipTest(equipTestDTO);
            if (count > 0) {
                log.info("移除设备检定信息结果: " + "移除数据条数 " + count);
                return ResultT.success("移除数据成功");
            } else {
                log.error("移除设备检定信息异常");
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("移除设备检定信息异常");
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
