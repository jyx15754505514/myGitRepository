package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-15 23:22
 */
@RestController
@RequestMapping("/seal")
public class CustomerController {

    private final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20883")
    CustomerService customerService;

    @RequestMapping(value = "/ListSeal", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT sayHello(@RequestBody CustomerDO customerDO){
        List<CustomerDO> customerList = null;
        try {
            customerList = customerService.listCustomer(customerDO);
            return ResultT.success(customerList);
        } catch (Exception e) {
            log.debug("根据条件查询封识失败", e);
            return ResultT.failure(ResultCode.DATA_IS_WRONG);
        }
    }





}
