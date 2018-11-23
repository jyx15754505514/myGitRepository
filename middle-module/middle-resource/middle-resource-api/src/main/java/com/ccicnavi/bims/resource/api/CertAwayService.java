package com.ccicnavi.bims.resource.api;

import com.ccicnavi.bims.common.ResultT;
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



}
