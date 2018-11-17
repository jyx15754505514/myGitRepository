package com.ccicnavi.bims.resource.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.QualificationCertService;
import com.ccicnavi.bims.resource.pojo.QualificationCertDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: QualificationCertController
 * @author: chaiyanshun
 * @create: 2018-11-15 20:09
 **/
@RestController
@RequestMapping("/qualificationcert")
public class QualificationCertController {

    private final static Logger log = LoggerFactory.getLogger(QualificationCertController.class);

    @Reference(timeout = 30000, url = "dubbo://127.0.0.1:20882")
    QualificationCertService qualificationCertService;

    /**@description: 查询人员资格证书
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:29
    *@Param [qualificationCertDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/listQualificationCert", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT listQualificationCert(@RequestBody QualificationCertDO qualificationCertDO){
        try {
            List<QualificationCertDO> qualificationCertlist = qualificationCertService.listQualificationCertDO(qualificationCertDO);
            return ResultT.success(qualificationCertlist);
        } catch (Exception e) {
            log.debug("查询人员资格证书信息失败", e);
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }

    /**@description: 新增人员资格证书
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:33
    *@Param [qualificationCertDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/insertQualificationCert", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT insertQualificationCert(@RequestBody QualificationCertDO qualificationCertDO){
        try {
            Integer num = qualificationCertService.insertQualificationCertDO(qualificationCertDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("新增人员资格证书信息失败", e);
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }

    /**@description: 修改人员资格证书
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:37
    *@Param [qualificationCertDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/updateQualificationCert", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT updateQualificationCert(@RequestBody QualificationCertDO qualificationCertDO){
        try {
            Integer num = qualificationCertService.updateQualificationCertDO(qualificationCertDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("修改人员资格证书信息失败", e);
        }
        return ResultT.failure(ResultCode.UPDATE_FAILURE);
    }

    /**@description: 删除人员资格证书
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:42
    *@Param [qualificationCertDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/deleteQualificationCert", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT deleteQualificationCert(@RequestBody QualificationCertDO qualificationCertDO){
        try {
            Integer num = qualificationCertService.deleteQualificationCertDO(qualificationCertDO);
            if(num != null && num != 0) {
                return ResultT.success();
            }
        } catch (Exception e) {
            log.debug("删除人员资格证书信息失败", e);
        }
        return ResultT.failure(ResultCode.DELETE_FAILURE);
    }

    /**@description: 根据主键查询人员资格证书
    *@author: ChaiYanShun
    *@create: 2018/11/16 15:46
    *@Param [qualificationCertDO]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/getQualificationCert", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getQualificationCert(@RequestBody QualificationCertDO qualificationCertDO){
        try {
            QualificationCertDO resultBean =  qualificationCertService.getQualificationCertDO(qualificationCertDO);
            if(resultBean != null) {
                return ResultT.success(resultBean);
            }
        } catch (Exception e) {
            log.debug("根据主键查询人员资格证书信息失败", e);
        }
        return ResultT.failure(ResultCode.GET_FAILURE );
    }

    /**@description: 分页查询人员资格证书
    *@author: ChaiYanShun
    *@create: 2018/11/16 21:05
    *@Param [pageParameter]
    *@return com.ccicnavi.bims.common.ResultT
    */
    @RequestMapping(value="/getQualificationCertPage", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultT getQualificationCertPage(@RequestBody PageParameter<QualificationCertDO> pageParameter){
        try {
            PageBean<QualificationCertDO> qualificationCertPage = qualificationCertService.getQualificationCertPage(pageParameter);
            return ResultT.success(qualificationCertPage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultT.failure(ResultCode.LIST_FAILURE);
        }
    }
}
