package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.order.api.OrderItemService;
import com.ccicnavi.bims.order.pojo.OrderItemDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* *
 * @Author MengZiJie
 * @Description 委托单服务项
 * @Date 17:32 2018/11/19
 */
@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

    private final static Logger log = LoggerFactory.getLogger(OrderItemController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20881")
    OrderItemService orderItemService;


    /* *
     * @Author MengZiJie
     * @Description 添加服务项
     * @Date 17:41 2018/11/19
     * @Param [orderItemDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/insertOrderItem",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertOrderItem(@RequestBody OrderItemDO orderItemDO){
        Integer integer = orderItemService.insertOrderItem(orderItemDO);
        if(integer > 0){
            return ResultT.success();
        }else{
           return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 更新服务项
     * @Date 17:42 2018/11/19
     * @Param [orderItemDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateOrderInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateOrderInfo(@RequestBody OrderItemDO orderItemDO){
        Integer integer = orderItemService.updateOrderItem(orderItemDO);
        if(integer > 0){
            return ResultT.success();
        }else{
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }
}
