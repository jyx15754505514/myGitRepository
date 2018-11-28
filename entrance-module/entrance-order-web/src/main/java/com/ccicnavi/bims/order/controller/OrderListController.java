package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/order")
public class OrderListController {


    //@Reference(timeout = 3000)
    @Reference(timeout = 3000, url="dubbo://127.0.0.1:20886")
    OrderInfoService orderInfoService;

    /*
     *@Param: [parameter]
     *@description: 获取委托单列表数据
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/28 9:59
     */
    @RequestMapping(value = "/listOrder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listOrder(@RequestBody PageParameter<OrderInfoDO> parameter) {
        try {
            PageBean<OrderInfoDO> orderInfoDOPageBean = orderInfoService.listOrderInfo(parameter);
            return ResultT.success(orderInfoDOPageBean);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /*
     *@Param: [parameter]
     *@description: 获取委托单列表数据
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/28 9:59
     */
    @RequestMapping(value = "/listBusinessOrder", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listBusinessOrder(@RequestBody PageParameter<OrderInfoDO> parameter) {
        try {
            PageBean<OrderInfoDO> orderInfoDOPageBean = null;
            return ResultT.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


}
