package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.order.api.OrderItemService;
import com.ccicnavi.bims.order.pojo.OrderItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderItemController
 * @Description TODO 委托方服务项
 * @Author ChaiYanShun
 * @Date 2018/11/28 10:00
 **/
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final static Logger log= LoggerFactory.getLogger(OrderItemController.class);

    @Reference(timeout = 30000)
    OrderItemService orderItemService;

    /**
    *@description: 更新服务项
    *@author: ChaiYanShun
    *@create: 2018/11/28 10:22
    *@Param [orderItemDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/updateOrderItem",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateOrderItem(@RequestBody OrderItemDTO orderItemDTO){
        try {
            Integer num = orderItemService.updateOrderItem(orderItemDTO);
            if(num > 0 ){
                return ResultT.success("更新服务项成功");
            }
        } catch (Exception e) {
            log.error("更新服务项失败",e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
    *@description: 删除服务项信息
    *@author: ChaiYanShun
    *@create: 2018/11/28 11:33
    *@Param [orderItemDTO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value = "/deleteOrderItem",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteOrderItem(@RequestBody OrderItemDTO orderItemDTO){
        try {
            Integer num = orderItemService.deleteOrderItem(orderItemDTO);
            if(num > 0){
                return ResultT.success("删除服务项信息成功");
            }
        } catch (Exception e) {
            log.error("删除服务项信息失败",e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }
}
