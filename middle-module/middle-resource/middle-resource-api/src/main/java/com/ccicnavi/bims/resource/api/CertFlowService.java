package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.resource.pojo.CertFlowDO;

/*
 * @Auther: heibin
 * @Date:2018/11/25 22:32
 * @Description: 证书纸管理-证书流水
 */
public interface CertFlowService {
    /*
     * 作废流水号
     * @param certPaper
     * @return
     */
    Integer cancelCertFlow(CertFlowDO certFlowDO) ;
}
