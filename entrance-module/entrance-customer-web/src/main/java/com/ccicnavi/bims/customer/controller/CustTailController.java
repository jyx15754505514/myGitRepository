package com.ccicnavi.bims.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustTailService;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
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
 * @description: 该类的作用描述
 * @author: LiJie
 * @create: 2018-11-17 11:46
 */
@RestController
@RequestMapping("/custTail")
public class CustTailController {


    private final static Logger log = LoggerFactory.getLogger(CustTailController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20883")
    CustTailService custTailService;

    /**
     * 查询全部客户跟踪信息
     * @return
     */
    @RequestMapping(value = "/listAllCustTail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listAllCustTail(@RequestBody CustTailDO custTailDO) {
        try {
            List<CustTailDO> CustTailList = custTailService.listCustTail(custTailDO);
            return ResultT.success(CustTailList);
        } catch (Exception e) {
            log.error("查询客户跟踪信息失败", e);
            return ResultT.failure(ResultCode.RESULE_DATA_NONE);
        }
    }

    /**
     * 分页查询全部客户跟踪信息
     *
     * @return
     */
    @RequestMapping(value = "/listCustTail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT listCustTail(@RequestBody PageParameter<CustTailDO> pageParameter) {
        try {
            PageBean<CustTailDO> roleDOList = custTailService.listCustTailPage(pageParameter);
            if (roleDOList != null) {
                return ResultT.success(roleDOList);
            }
        } catch (Exception e) {
            log.error("根据条件查询客户跟踪失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * 根据主键查询客户跟踪信息
     * @return
     */
    @RequestMapping(value = "/getCustTail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT getCustTail(@RequestBody CustTailDO custTailDO) {
        try {
            if (!StringUtils.isEmpty(custTailDO.getTailUuid())) {
                CustTailDO custTail = custTailService.getCustTail(custTailDO);
                if (custTail != null) {
                    return ResultT.success(custTail);
                }
            } else {
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
        } catch (Exception e) {
            log.error("根据主键查询客户跟踪失败", e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }


    /**
     * 新增客户跟踪信息
     */
    @RequestMapping(value = "/saveCustTail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT saveCustTail(@RequestBody CustTailDO custTailDO) {
        try {
            Integer count = custTailService.saveCustTail(custTailDO);
            if (count > 0) {
                return ResultT.success("新增客户跟踪成功");
            } else {
                return ResultT.failure(ResultCode.ADD_FAILURE);
            }
        } catch (Exception e) {
            log.error("新增客户跟踪失败", e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }

    /**
     * 修改客户跟踪信息
     */
    @RequestMapping(value = "/updateCustTail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT updateCustTail(@RequestBody CustTailDO custTailDO) {
        try {
            Integer count = custTailService.updateCustTail(custTailDO);
            if (count > 0) {
                return ResultT.success("修改客户跟踪成功");
            } else {
                return ResultT.failure(ResultCode.UPDATE_FAILURE);
            }
        } catch (Exception e) {
            log.error("修改客户跟踪失败", e);
            return ResultT.failure(ResultCode.UPDATE_FAILURE);
        }
    }

    /**
     * 删除客户跟踪信息
     */
    @RequestMapping(value = "/removeCustTail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultT removeCustTail(@RequestBody CustTailDO custTailDO) {
        try {
            Integer count = custTailService.removeCustTail(custTailDO);
            if (count > 0) {
                return ResultT.success("删除客户跟踪成功");
            } else {
                return ResultT.failure(ResultCode.DELETE_FAILURE);
            }
        } catch (Exception e) {
            log.error("删除客户跟踪失败", e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


}
