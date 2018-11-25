package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.CertFlowDO;

/**
 * @Auther: hebin
 * @Date: 2018/11/25 21:39
 * @Description:  证书纸管理-证书流水
 */
public interface CertFlowDao {
    /*
     * 新增证书流水
     * @param certFlowDO
     * @return Integer
     * @throws Exception
     */
    public Integer insertCertFlow(CertFlowDO certFlowDO) throws Exception;
    /*
     * 作废流水号
     * @param certFlowDO
     * @return Integer
     * @throws Exception
     */
    public Integer cancelCertFlow(CertFlowDO certFlowDO) throws Exception;

}
