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

/*
*@Param:
*@description: 设备管理
*@return:
*@author: WangGengXiang
*@create: 2018/11/26 20:21
*/
@RestController
@RequestMapping(value = "/expire")
@Slf4j
public class ExpireEquipController {


   /* @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20882")
    EquipService equipService;*/

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    EquipTestService equipTestService;

    /*
     *@Param: [pageParameter]
     *@description: 设备检定列表
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/26 17:29
     */
    @RequestMapping(value = "listExpireTestTypePage", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listExpireTestTypePage(@RequestBody PageParameter<EquipTestDO> pageParameter) {
        try {
            PageBean<EquipTestDO> EquipTestList = equipTestService.listEquipTest(pageParameter);
            if (null == EquipTestList) {
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
            return ResultT.success(EquipTestList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
     *@Param: [equipTestDO]
     *@description: 设备检定新增
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/26 17:28
     */
    @RequestMapping(value = "saveEquipTest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveEquipTest(@RequestBody EquipTestDO equipTestDO) {
        try {
            Integer count = equipTestService.insertEquipTest(equipTestDO);
            if (count > 0) {
                return ResultT.success("保存数据成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /*
     *@Param: [equipTestDO]
     *@description: 更新设备检定
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/26 17:28
     */
    @RequestMapping(value = "/updateEquipTest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateEquipTest(@RequestBody EquipTestDO equipTestDO) {
        try {
            Integer EquipTestList = equipTestService.updateEquipTest(equipTestDO);
            return ResultT.success("更新设备检定");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /*
     *@Param: [equipTestDTO]
     *@description: 根据设备检定主键删除设备检定
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/26 17:28
     */
    @RequestMapping(value = "deleteEquipTest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteEquipTest(@RequestBody EquipTestDTO equipTestDTO) {
        try {
            Integer count = equipTestService.deleteEquipTest(equipTestDTO);
            if (count > 0) {
                return ResultT.success("移除数据成功");
            } else {
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
