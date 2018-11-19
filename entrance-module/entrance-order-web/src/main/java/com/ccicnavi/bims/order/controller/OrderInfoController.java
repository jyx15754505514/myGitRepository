package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* *
 * @Author MengZiJie
 * @Description 委托单
 * @Date 17:32 2018/11/19
 */
@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

    private final static Logger log = LoggerFactory.getLogger(OrderInfoController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20881")
    OrderInfoService orderInfoService;


    /* *
     * @Author MengZiJie
     * @Description 添加委托单
     * @Date 17:38 2018/11/19
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/insertOrderInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT insertOrderInfo(@RequestBody OrderInfoDO orderInfoDO){
        Integer integer = orderInfoService.insertOrderInfo(orderInfoDO);
        if(integer > 0){
            return ResultT.success();
        }else{
           return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /* *
     * @Author MengZiJie
     * @Description 更新委托单
     * @Date 17:39 2018/11/19
     * @Param [orderInfoDO]
     * @Return com.ccicnavi.bims.common.ResultT
     */
    @RequestMapping(value = "/updateOrderInfo",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateOrderInfo(@RequestBody OrderInfoDO orderInfoDO){
        Integer integer = orderInfoService.updateOrderInfo(orderInfoDO);
        if(integer > 0){
            return ResultT.success();
        }else{
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }
}
