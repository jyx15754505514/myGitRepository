package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertAwayService;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

        try {
            return certAwayService.insertCertAway(certAwayDO);
        } catch (Exception e) {
            log.error("分发失败" + e);
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

        try {
            PageBean<CertAwayDO> pageBean = certAwayService.listCertAwayPage(pageParameter);
            if(pageBean != null){
                return ResultT.success(pageBean);
            }
            return ResultT.failure(ResultCode.LIST_FAILURE);
        } catch (Exception e) {
            log.error("获取分发记录列表" + e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }








}
