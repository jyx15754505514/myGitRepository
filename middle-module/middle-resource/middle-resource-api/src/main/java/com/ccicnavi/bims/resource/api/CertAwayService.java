package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;

/*
 * @Auther: heibin
 * @Date: 2018/11/14 16:04
 * @Description: 证书纸管理-分发记录
 */
public interface CertAwayService {
    /*
     * 新增分发记录
     * @param certPaper
     * @return Integer
     */
    ResultT insertCertAway(CertAwayDO certAwayDO) ;
    /*
     * @Author heibin
     * @Description 证书纸管理-分发记录分页列表
     * @Date 22:25 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertAwayDO>
     */
    PageBean<CertAwayDO> listCertAwayPage(PageParameter<CertAwayDO> pageParameter);
    /*
     * 作废证书纸
     * @param certPaper
     * @return
     */
    Integer deleteCertAway(CertAwayDO certAwayDO) ;


}
