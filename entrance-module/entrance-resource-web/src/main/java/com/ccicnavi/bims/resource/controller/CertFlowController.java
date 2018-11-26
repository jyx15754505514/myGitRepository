package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertFlowService;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bims-backend
 * @description: 证书流水
 * @author: limin
 * @create: 2018-11-26 15:16
 */
@Slf4j
@RestController
@RequestMapping(value = "/certFlow")
public class CertFlowController {

    @Reference(timeout = 30000)
    CertFlowService certFlowService;

    /**
     * TODO 证书号流水号作废
     * @Param certFlowDO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/26 14:53
     **/
    @RequestMapping(value = "/cancelCertFlow",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT cancelCertFlow(@RequestBody CertFlowDO certFlowDO) {

        try {
            Integer num = certFlowService.cancelCertFlow(certFlowDO);
            if(num >= 1){
                return ResultT.success();
            }
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        } catch (Exception e) {
            log.error("作废分发记录失败" + e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


    /**
     * TODO 证书流水列表
     * @Param certFlowDO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/26 14:53
     **/
    @RequestMapping(value = "/listCertFlowPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCertFlowPage(@RequestBody PageParameter<CertFlowDO> pageParameter) {

        try {
            PageBean<CertFlowDO> pageBean = certFlowService.listCertFlowPage(pageParameter);
            if(pageBean != null){
                return ResultT.success(pageBean);
            }
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("证书流水列表获取失败" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


}
