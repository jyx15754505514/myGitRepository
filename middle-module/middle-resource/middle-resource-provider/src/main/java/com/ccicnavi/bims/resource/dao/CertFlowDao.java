package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import org.n3r.eql.EqlTran;

/**
 * @Auther: hebin
 * @Date: 2018/11/25 21:39
 * @Description:  证书纸管理-证书流水
 */
public interface CertFlowDao {
    /**
     * 新增证书流水
     * @param certFlowDO
     * @return Integer
     * @throws Exception
     */
    public Integer insertCertFlow(CertFlowDO certFlowDO, EqlTran tran) throws Exception;
    /**
     * 作废流水号
     * @param certFlowDO
     * @return Integer
     * @throws Exception
     */
    public Integer cancelCertFlow(CertFlowDO certFlowDO) throws Exception;
    /**
     * @Author heibin
     * @Description  证书纸管理-证书流水分页列表
     * @Date 9:45 2018/11/26
     * @Param [CertFlowDO]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertFlowDO>
     */
    PageBean<CertFlowDO> listCertFlowPage(PageParameter<CertFlowDO> certFlowDO) throws Exception;

}
