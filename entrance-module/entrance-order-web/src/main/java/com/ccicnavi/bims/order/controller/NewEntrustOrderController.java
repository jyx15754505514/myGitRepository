package com.ccicnavi.bims.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/NewEntrust")
public class NewEntrustOrderController {

    @Reference(version = "1.0.0", timeout = 1000, url = "dubbo://127.0.0.1:20886")
    CustomerService customerService;

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

}
