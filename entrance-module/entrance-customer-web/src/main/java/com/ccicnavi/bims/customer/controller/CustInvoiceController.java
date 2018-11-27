package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustInvoiceService;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
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
 * @description: 客户发票资源调度
 * @author: LiJie
 * @create: 2018-11-17 11:37
 */
@RestController
@RequestMapping("/custInvoice")
public class CustInvoiceController {

    private final static Logger log = LoggerFactory.getLogger(CustInvoiceController.class);

    @Reference(timeout = 30000)
    CustInvoiceService custInvoiceService;

    /**
     * 查询全部客户发票信息
     * @return
     */
    @RequestMapping(value = "/listAllCustInvoice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCustInvoice(@RequestBody CustInvoiceDO custInvoiceDO) {
        try {
            List<CustInvoiceDO> CustInvoiceList = custInvoiceService.listCustInvoice(custInvoiceDO);
            return ResultT.success(CustInvoiceList);
        } catch (Exception e) {
            log.error("查询客户发票信息失败", e);
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        }
    }

    /**
     * 分页查询全部客户发票信息
     *
     * @return
     */
    @RequestMapping(value = "/listCustInvoice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCustInvoice(@RequestBody PageParameter<CustInvoiceDO> pageParameter) {
        try {
            PageBean<CustInvoiceDO> roleDOList = custInvoiceService.listCustInvoicePage(pageParameter);
            if (roleDOList != null) {
                return ResultT.success(roleDOList);
            }
        } catch (Exception e) {
            log.error("根据条件查询客户发票失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * 根据主键查询客户发票信息
     *
     * @return
     */
    @RequestMapping(value = "/getCustInvoice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCustInvoice(@RequestBody CustInvoiceDO custInvoiceDO) {
        if(StringUtils.isEmpty(custInvoiceDO.getInvoiceUuid())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            CustInvoiceDO custInvoice = custInvoiceService.getCustInvoice(custInvoiceDO);
            if (custInvoice != null) {
                return ResultT.success(custInvoice);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户发票失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * 新增客户发票信息
     */
    @RequestMapping(value = "/saveCustInvoice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCustInvoice(@RequestBody CustInvoiceDO custInvoiceDO) {
        try {
            Integer count = custInvoiceService.saveCustInvoice(custInvoiceDO);
            if (count > 0) {
                return ResultT.success("新增客户发票成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户发票失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 修改客户发票信息
     */
    @RequestMapping(value = "/updateCustInvoice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustInvoice(@RequestBody CustInvoiceDO custInvoiceDO) {
        try {
            Integer count = custInvoiceService.updateCustInvoice(custInvoiceDO);
            if (count > 0) {
                return ResultT.success("修改客户发票成功");
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            log.error("修改客户发票失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * 删除客户发票信息
     */
    @RequestMapping(value = "/removeCustInvoice", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeCustInvoice(@RequestBody CustInvoiceDO custInvoiceDO) {
        if(StringUtils.isEmpty(custInvoiceDO.getUuids())){
            return ResultT.failure(ResultCode.PARAM_IS_BLANK);
        }
        try {
            Integer count = custInvoiceService.removeCustInvoice(custInvoiceDO);
            if (count > 0) {
                return ResultT.success("删除客户发票成功");
            } else {
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户发票失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
