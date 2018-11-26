package com.ccicnavi.bims.resource.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertFlowService;
import com.ccicnavi.bims.resource.dao.CertFlowDao;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: heibin
 * @Date: 2018/11/25 22:37
 * @Description: 证书纸管理-证书流水表
 */
@Service
@Slf4j
public class CertFlowServiceImpl implements CertFlowService {
    @Autowired
    CertFlowDao certFlowDao;
    /**
     * 作废流水号
     * @param certFlowDO
     * @return Integer
     */
    @Override
    public Integer cancelCertFlow(CertFlowDO certFlowDO) {
        try {
            return certFlowDao.cancelCertFlow(certFlowDO);
        } catch (Exception e) {
            log.error("作废流水号失败",e);
        }
        return 0;
    }
    /**
     * @Author heibin
     * @Description  证书纸管理-证书流水分页列表
     * @Date 9:30 2018/11/26
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertFlowDO>
     */
    @Override
    public PageBean<CertFlowDO> listCertFlowPage(PageParameter<CertFlowDO> pageParameter) {
        try {
            return certFlowDao.listCertFlowPage(pageParameter);
        } catch (Exception e) {
            log.error(" 证书纸管理-证书流水分页列表查询失败",e);
            return null;
        }
    }
}
