package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertFlowService;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import com.ccicnavi.bims.resource.pojo.CertFlowDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
     * TODO 证书流水号作废
     * @Param certFlowDO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/26 14:53
     **/
    @RequestMapping(value = "/cancelCertFlow",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT cancelCertFlow(@RequestBody CertFlowDO certlowDO) {
        log.debug("开始作废证书流水号 Param: " + JSON.toJSONString(certlowDO) + " Time: " + new Date());
        try {
            if(StringUtils.isEmpty(certlowDO.getFlowNum())){
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            //目前暂定于作废两个状态
            certlowDO.setEmptyCardStatus("Y");
            certlowDO.setIsDeleted("Y");
            Integer count = certFlowService.cancelCertFlow(certlowDO);
            if(count >= 1){
                log.debug("作废证书流水号数量：作废数量" + count);
                return ResultT.success();
            }
            log.debug("作废证书流水号异常");
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        } catch (Exception e) {
            log.error("作废证书流水号异常" + e);
            return ResultT.failure(ResultCode.DELETE_FAILURE);
        }
    }


    /**
     * TODO 证书流水号列表
     * @Param certFlowDO
     * @return ResultT
     * @Author limin
     * @Date  2018/11/26 14:53
     **/
    @RequestMapping(value = "/listCertFlowPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCertFlowPage(@RequestBody PageParameter<CertFlowDO> pageParameter) {
        log.debug("开始获取证书流水号列表 Param: " + JSON.toJSONString(pageParameter) + " Time: " + new Date());
        try {
            if(StringUtils.isEmpty(pageParameter.getStartPage()) ||
                    StringUtils.isEmpty(pageParameter.getPageRows())   ){
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            PageBean<CertFlowDTO> pageBean = certFlowService.listCertFlowPage(pageParameter);
            if(null == pageBean){
                log.debug("获取证书流水号列表异常");
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
            log.debug("获取证书流水号列表结果：" + JSON.toJSONString(pageBean));
            return ResultT.success(pageBean);

        } catch (Exception e) {
            log.error("获取证书流水号列表异常" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }


}
