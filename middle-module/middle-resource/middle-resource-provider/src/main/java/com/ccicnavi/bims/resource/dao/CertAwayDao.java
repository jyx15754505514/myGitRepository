package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import org.n3r.eql.EqlTran;

/**
 * @Auther: hebin
 * @Date: 2018/11/23 21:43
 * @Description:  证书纸管理-分发记录
 */
public interface CertAwayDao {
    /**
     * 新增分发记录
     * @param certAwayDO
     * @return Integer
     * @throws Exception
     */
    public Integer insertCertAway(CertAwayDO certAwayDO, EqlTran tran) throws Exception;
    /**
     * @Author heibin
     * @Description  证书纸管理-分发记录分页列表
     * @Date 22:34 2018/11/23
     * @Param [certAwayDO]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertAwayDO>
     */
    PageBean<CertAwayDO> listCertAwayPage(PageParameter<CertAwayDO> certAwayDO) throws Exception;
    /**
     * 作废证书纸管理-分发记录
     * @param certAwayDO
     * @return Integer
     * @throws Exception
     */
    public Integer deleteCertAway(CertAwayDO certAwayDO) throws Exception;

}
