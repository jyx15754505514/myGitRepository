package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertAwayService;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @program: bims-backend
 * @description: 证书纸分发
 * @author: limin
 * @create: 2018-11-26 14:27
 */
@Slf4j
@RestController
@RequestMapping(value = "/certAway")
public class CertAwayController {

    @Reference(timeout = 30000)
    CertAwayService certAwayService;

    /**
    * TODO 空证书纸分发
    * @Param certAwayDO
    * @return ResultT
    * @Author limin
    * @Date  2018/11/26 14:53
    **/
    @RequestMapping(value = "/insertCertAway",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT insertCertAway(@RequestBody CertAwayDO certAwayDO) {
        log.info("开始保存空证书纸分发记录 Param: " + JSON.toJSONString(certAwayDO) + " Time: " + new Date());
        try {
            log.info("保存空证书纸分发成功记录");
            return certAwayService.insertCertAway(certAwayDO);
        } catch (Exception e) {
            log.error("保存空证书纸分发记录失败" + e);
            return ResultT.failure(ResultCode.ADD_FAILURE);
        }
    }


    /**
     * TODO 按条件获取分发记录列表
     * @Param pageParameter
     * @return ResultT
     * @Author limin
     * @Date  2018/11/26 14:53
     **/
    @RequestMapping(value = "/listCertAwayPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCertAwayPage(@RequestBody PageParameter<CertAwayDO> pageParameter) {
        log.info("开始获取分发记录列表 Param: " + JSON.toJSONString(pageParameter) + " Time: " + new Date());
        try {
            if(StringUtils.isEmpty(pageParameter.getPageRows()) ||
               StringUtils.isEmpty(pageParameter.getStartPage())){
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            PageBean<CertAwayDO> pageBean = certAwayService.listCertAwayPage(pageParameter);
            if(null == pageBean ){
                log.info("获取分发记录列表异常");
                return ResultT.failure(ResultCode.LIST_FAILURE);
            }
            log.info("获取分发记录列表结果：" + JSON.toJSONString(pageBean));
            return ResultT.success(pageBean);
        } catch (Exception e) {
            log.error("获取分发记录列表失败" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }








}
