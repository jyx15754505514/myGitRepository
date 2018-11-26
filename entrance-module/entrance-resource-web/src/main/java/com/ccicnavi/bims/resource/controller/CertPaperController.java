package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertPaperService;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: 证书纸
 * @author: chaiyanshun
 * @create: 2018-11-15 20:09
 **/
@RestController
@RequestMapping("/certPaper")
public class CertPaperController {

    private final static Logger log = LoggerFactory.getLogger(CertPaperController.class);

    @Reference(timeout = 30000)
    CertPaperService certPaperService;

    /**
    *@description: 分页查询空台账列表
    *@author: ChaiYanShun
    *@create: 2018/11/26 11:23
    *@Param [pageParameter]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/listCertPaperPage",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listCertPaperPage(@RequestBody PageParameter<CertPaperDO> pageParameter){
        try {
            PageBean<CertPaperDO> pageBean = certPaperService.listCertPaperPage(pageParameter);
            if(pageBean != null){
                return ResultT.success(pageBean);
            }
        } catch (Exception e) {
            log.error("分页查询空证台账列表失败",e);
        }
        return ResultT.failure(ResultCode.LIST_FAILURE);
    }

    /**
    *@description: 新增空证信息
    *@author: ChaiYanShun
    *@create: 2018/11/26 11:39
    *@Param [certPaper]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/insertCertPaper",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT insertCertPaper(@RequestBody CertPaperDO certPaper){
        try {
            if(certPaper.getProdCatalogUuid() == null || certPaper.getOrgUuid() == null || certPaper.getAppSysUuid() == null){
                return ResultT.failure(ResultCode.PARAM_IS_BLANK);
            }
            Integer num = certPaperService.insertCertPaper(certPaper);
            if (num != null && num > 0){
                return ResultT.success("新增空证成功");
            }
        } catch (Exception e) {
            log.error("新增空证失败",e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**
    *@description: 修改空证信息
    *@author: ChaiYanShun
    *@create: 2018/11/26 14:42
    *@Param [certPaper]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/updateCertPaper",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateCertPaper(@RequestBody CertPaperDO certPaper){
        try {
            Integer num = certPaperService.updateCertPaper(certPaper);
            if( num > 0){
                return ResultT.success("修改空证信息成功");
            }
        } catch (Exception e) {
            log.error("修改空证信息失败",e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**
    *@description: 根据证书纸paperUuid找到证书纸信息
    *@author: ChaiYanShun
    *@create: 2018/11/26 14:48
    *@Param [certPaper]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/getCertPaper",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getCertPaper(@RequestBody CertPaperDO certPaper){
        try {
            CertPaperDO resultBean = certPaperService.getCertPaper(certPaper);
            if(resultBean != null){
                return ResultT.success(resultBean);
            }
        } catch (Exception e) {
            log.error("根据证书纸paperUuid找到证书纸信息",e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE);
    }

    /**
    *@description: 删除证书纸
    *@author: ChaiYanShun
    *@create: 2018/11/26 14:53
    *@Param [certPaper]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/deleteCertPaper",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT deleteCertPaper(@RequestBody CertPaperDO certPaper){
        try {
            Integer num = certPaperService.deleteCertPaper(certPaper);
            if(num > 0){
                return ResultT.success("删除证书纸成功");
            }
        } catch (Exception e) {
            log.error("删除证书纸失败",e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }
}
