package com.ccicnavi.bims.resource.dao;

import com.ccicnavi.bims.resource.pojo.CertAwayDO;

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
    public Integer insertCertAway(CertAwayDO certAwayDO) throws Exception;
}
