package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustAddrService;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
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
 * @description: 客户端分包方资源调度
 * @author: LiJie
 * @create: 2018-11-17 09:45
 */
@RestController
@RequestMapping("/custAddr")
public class CustAddrController {

    private final static Logger log = LoggerFactory.getLogger(CustAddrController.class);

    @Reference(timeout = 30000)
    CustAddrService custAddrService;

    /**
    *@Description: 查询客户地址信息(不分页)
    *@Param: custAddrDO
    *@return: List<CustAddrDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/listAllCustAddr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCustAddr(@RequestBody CustAddrDO custAddrDO) {
        try {
            List<CustAddrDO> CustAddrList = custAddrService.listCustAddr(custAddrDO);
            return ResultT.success(CustAddrList);
        } catch (Exception e) {
            log.error("查询客户地址信息失败", e);
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        }
    }

    /**
    *@Description: 查询客户地址信息(分页)
    *@Param: pageParameter
    *@return: PageBean<CustAddrDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/listCustAddr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCustAddr(@RequestBody PageParameter<CustAddrDO> pageParameter) {
        try {
            PageBean<CustAddrDO> custAddrList = custAddrService.listCustAddrPage(pageParameter);
            if (custAddrList != null) {
                return ResultT.success(custAddrList);
            }
        } catch (Exception e) {
            log.error("根据条件查询客户地址失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
    *@Description: 根据主键查询客户地址信息
    *@Param: custAddrDO
    *@return: CustAddrDO
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/getCustAddr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCustAddr(@RequestBody CustAddrDO custAddrDO) {
        if(StringUtils.isEmpty(custAddrDO.getAddrUuid())){
            ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            CustAddrDO custAddr = custAddrService.getCustAddr(custAddrDO);
            if (custAddr != null) {
                return ResultT.success(custAddr);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
    *@Description: 新增客户地址信息
    *@Param: custAddrDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/saveCustAddr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCustAddr(@RequestBody CustAddrDO custAddrDO) {
        try {
            Integer count = custAddrService.saveCustAddr(custAddrDO);
            if (count > 0) {
                return ResultT.success("新增客户地址成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户地址失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
    *@Description: 修改客户地址信息
    *@Param: CustAddrDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/updateCustAddr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustAddr(@RequestBody CustAddrDO CustAddrDO) {
        try {
            if(!StringUtils.isEmpty(CustAddrDO.getAddrUuid())){
                Integer count = custAddrService.updateCustAddr(CustAddrDO);
                return ResultT.success("修改客户地址成功");
            }else{
                    return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
        } catch (Exception e) {
            log.error("修改客户地址失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
    *@Description: 删除客户地址信息
    *@Param: custAddrDO
    *@return: Integer
    *@Author: zqq
    *@date: 2018/11/19
    */

    @RequestMapping(value = "/removeCustAddr", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeCustAddr(@RequestBody CustAddrDO custAddrDO) {
        if(StringUtils.isEmpty(custAddrDO.getUuids())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer count = custAddrService.removeCustAddr(custAddrDO);
            if (count > 0) {
                return ResultT.success("删除客户地址成功");
            } else {
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户地址失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }
}
