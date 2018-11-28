package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import com.ccicnavi.bims.resource.pojo.CertFlowDTO;

/**
 * @Auther: heibin
 * @Date:2018/11/25 22:32
 * @Description: 证书纸管理-证书流水
 */
public interface CertFlowService {
    /**
     * 作废流水号
     * @param certFlowDO
     * @return
     */
    Integer cancelCertFlow(CertFlowDO certFlowDO) ;
    /**
     * @Author heibin
     * @Description 证证书纸管理-证书流水分页列表
     * @Date 9:22 2018/11/26
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertFlowDO>
     */
    PageBean<CertFlowDTO> listCertFlowPage(PageParameter<CertFlowDO> pageParameter);
}
