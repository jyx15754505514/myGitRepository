package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustomerService;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import com.ccicnavi.bims.customer.pojo.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户端客户服务请求
 * @author: LiJie
 * @create: 2018-11-15 23:22
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final static Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20883")
    CustomerService customerService;

    /**
    *@Description: 查询全部客户信息(不分页)
    *@Param: customerDO
    *@return: List<CustomerDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/listAllCustomer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCustomer(@RequestBody CustomerDO customerDO) {
        try {
            List<CustomerDO> customerList = customerService.listCustomer(customerDO);
            return ResultT.success(customerList);
        } catch (Exception e) {
            log.error("查询客户信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**
    *@Description: 查询客户信息(分页)
    *@Param: pageParameter
    *@return: PageBean<CustomerDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/listCustomer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCustomer(@RequestBody PageParameter<CustomerDO> pageParameter) {
        try {
            PageBean<CustomerDO> roleDOList = customerService.listCustomerPage(pageParameter);
            return ResultT.success(roleDOList);
        } catch (Exception e) {
            log.error("根据条件查询客户失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


   /**
   *@Description: 根据主键查询客户信息
   *@Param: customerDO
   *@return: CustomerDO
   *@Author: zqq
   *@date: 2018/11/19
   */

    @RequestMapping(value = "/getCustomer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCustomer(@RequestBody CustomerDO customerDO) {
        if(StringUtils.isEmpty(customerDO.getCustUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            CustomerDO customer = customerService.getCustomer(customerDO);
            if (customer != null) {
                return ResultT.success(customer);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
    *@Description: 新增客户信息
    *@Param: customerDTO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCustomer(@RequestBody CustomerDO customerDO) {
        try {
            Integer count = customerService.saveCustomer(customerDO);
            if (count > 0) {
                return ResultT.success("新增客户成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
    *@Description: 修改客户信息
    *@Param: customerDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustomer(@RequestBody CustomerDO customerDO) {
        try {
            Integer count = customerService.updateCustomer(customerDO);
            if(count > 0){
                return ResultT.success("修改客户成功");
            }else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }

        } catch (Exception e) {
            log.error("修改客户失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

   /**
   *@Description: 删除客户信息
   *@Param: customerDO
   *@return: Integer
   *@Author: zqq
   *@date: 2018/11/19
   */

    @RequestMapping(value = "/removeCustomer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeCustomer(@RequestBody CustomerDO customerDO) {
        if(StringUtils.isEmpty(customerDO.getUuids())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer count = customerService.removeCustomer(customerDO);
            if(count > 0){
                return ResultT.success("删除客户成功");
            }else{
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


   /**
   *@Description: 客户信息唯一性校验
   *@Param:customerDO
   *@return:
   *@Author: zqq
   *@date: 2018/11/19
   */

    @RequestMapping(value = "/verifyCustInfoOnly", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT verifyCustInfoOnly(@RequestBody CustomerDO customerDO) {
        try {
            if(!StringUtils.isEmpty(customerDO.getCustName()) || !StringUtils.isEmpty(customerDO.getCustCode()) || !StringUtils.isEmpty(customerDO.getCustUscc())){
                return customerService.verifyCustInfoOnly(customerDO);
            }else {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
        } catch (Exception e) {
            log.error("客户信息唯一性验证失败~", e);
            return ResultT.failure(ResultCode.VERIFY_CUSTINFO_ONLY_FAILURE);
        }
    }


    @RequestMapping(value = "/getCustomerUuid", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCustomerUuid(@RequestBody CustomerDO customerDO) {
        if(StringUtils.isEmpty(customerDO.getCustUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            CustomerDTO customer = customerService.getCustomerUuid(customerDO);
            if (customer != null) {
                return ResultT.success(customer);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }
}
