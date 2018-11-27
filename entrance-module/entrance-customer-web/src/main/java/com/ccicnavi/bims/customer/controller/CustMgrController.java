package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustMgrService;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 11:49
 * @Description: 客户跟进人管理
 * @Version 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustMgrController {

    private final static Logger log = LoggerFactory.getLogger(CustMgrController.class);
    @Reference(timeout = 30000,url = "dubbo://127.0.0.1:20883")
    CustMgrService custMgrService;

    /**
    *@Description: 获取客户所有跟进人(不分页)
    *@Param: customerDO
    *@return: List<CustomerDO>
    *@Author: zqq
    *@date: 2018/11/19
            */

    @RequestMapping(value = "/listCustMgr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCustMgr(@RequestBody CustMgrDO custMgrDO) {
        try {
            List<CustMgrDO> customerList = custMgrService.listCustMgr(custMgrDO);
            return ResultT.success(customerList);
        } catch (Exception e) {
            log.error("查询客户跟进人信息失败", e);
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
    public ResultT listCustomer(@RequestBody PageParameter<CustMgrDO> pageParameter) {
        try {
            PageBean<CustMgrDO> custMgrPage = custMgrService.listCustMgrPage(pageParameter);
            return ResultT.success(custMgrPage);
        } catch (Exception e) {
            log.error("分页查询客户跟进人失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     * 功能描述: 获取跟进人详细信息
     * @param: custMgrDO
     * @return: ResultT
     * @date: 2018/11/27 11:58
     * @auther: congzhiyuan
     */
    @RequestMapping(value = "/getCustMgrInfo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCustomer(@RequestBody CustMgrDO custMgrDO) {
        try {
            CustMgrDO result = custMgrService.getCustMgr(custMgrDO);
            if (result != null) {
                return ResultT.success(result);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户跟进人失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
     * 功能描述: 添加客户跟进人信息
     * @param: custMgrDO
     * @return: ResultT
     * @date: 2018/11/27 11:58
     * @auther: congzhiyuan
     */
    @RequestMapping(value = "/insertCustMgr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCustomer(@RequestBody CustMgrDO custMgrDO) {
        try {
            Integer count = custMgrService.insertCustMgr(custMgrDO);
            if (count > 0) {
                return ResultT.success("新增客户跟进人成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户跟进人失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
    /**
     * 功能描述: 删除客户跟进人信息
     * @param: custMgrDO
     * @return: ResultT
     * @date: 2018/11/27 11:58
     * @auther: congzhiyuan
     */
    @RequestMapping(value = "/deleteCustMgr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT deleteCustomer(@RequestBody CustMgrDO custMgrDO) {
        try {
            Integer count = custMgrService.deleteCustMgr(custMgrDO);
            if (count > 0) {
                return ResultT.success("删除客户跟进人成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户跟进人失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }
}
