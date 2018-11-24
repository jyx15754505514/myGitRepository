package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.order.api.OrderInfoService;
import com.ccicnavi.bims.order.pojo.OrderInfoDO;
import com.ccicnavi.bims.order.pojo.OrderInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/NewEntrust")
public class NewEntrustOrderController {

    @Reference(timeout = 1000)
    CustomerService customerService;


    @Reference(timeout = 1000000)
    OrderInfoService orderInfoService;

    /*
     *@Param: [customerName]
     *@description: 根据客户名称,搜索客户信息
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/19 15:07
     */
    @RequestMapping("/listCustomer")
    public ResultT listCustomerByName(@RequestParam(required = false, value = "") String customerName) {
        CustomerDO customerDO = new CustomerDO();
        customerDO.setCustName(customerName);
        List<CustomerDO> customerDOList = customerService.listCustomer(customerDO);
        return ResultT.success(customerDOList);
    }

    /*
     *@Param: [sourceName]
     *@description: 根据客户来源名称,获取所有客户来源类型
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/19 16:08
     */
    @RequestMapping("/listCustomerSource")
    public ResultT listCustomerSource(@RequestParam(required = false, value = "") String sourceName) {
        return ResultT.success();
    }

    /*
    *@Param: [rate]
    *@description: 根据订单率名称 获取咨询订单赢率
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/19 16:16
    */
    @RequestMapping("/listWinRate")
    public ResultT listWinRate(@RequestParam(required = false, value = "") String rate){
        return ResultT.success();
    }

    /*
     *@Param: [categoryName]
     *@description: 根据产品类别名称,获取查看类别
     *@return: com.ccicnavi.bims.common.ResultT
     *@author: WangGengXiang
     *@create: 2018/11/19 16:05
     */
    @RequestMapping("/listProductCategory")
    public ResultT listProductCategory(@RequestParam(required = false, value = "") String categoryName) {
        return ResultT.success();
    }

    /*
    *@Param: [categoryName]
    *@description: 根据产品类别信息 获取产品列表信息(分页)
    *@return: com.ccicnavi.bims.common.ResultT
    *@author: WangGengXiang
    *@create: 2018/11/19 16:19
    */
    @RequestMapping("/listProductByCategory")
    public ResultT listProductByCategory(@RequestParam(required = false, value = "") String categoryName){
        return ResultT.success();
    }

    /**
     * TODO 查询委托单列表
     * @Param
     * @return
     * @Author limin
     * @Date  2018/11/21 19:58
     **/
    @RequestMapping(value = "/listOrderInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listOrderInfo(@RequestBody PageParameter<OrderInfoDO> pageParameter ){

        PageBean<OrderInfoDO> pageBean = null;

        try {
            pageBean = orderInfoService.listOrderInfo(pageParameter);
            if(pageBean != null){
                return  ResultT.success(pageBean);
            }
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        } catch (Exception e) {
            log.error("获取委托单列表失败"+e);
            return  ResultT.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
    }


    /**
     * TODO 获取委托单信息
     * @Param
     * @return
     * @Author limin
     * @Date  2018/11/21 19:58
     **/
    @RequestMapping(value = "/getOrderInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getOrderInfo(@RequestBody OrderInfoDO orderInfoDO ){

        OrderInfoDTO bean = null;

        try {
            bean = orderInfoService.getOrderInfo(orderInfoDO);
            if(bean != null){
                return  ResultT.success(bean);
            }
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        } catch (Exception e) {
            log.error("获取委托单列表失败"+e);
            return  ResultT.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
    }


    /**
     * TODO 委托单新增
     * @Param
     * @return
     * @Author limin
     * @Date  2018/11/21 19:58
     **/
    @RequestMapping(value = "/saveOrderInfo",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT saveOrderInfo(@RequestBody OrderInfoDTO orderInfoDTO ){

        try {
            return orderInfoService.saveOrderInfo(orderInfoDTO);
        } catch (Exception e) {
            log.error("获取委托单列表失败" + e);
            return  ResultT.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
        }
    }




}
