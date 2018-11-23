package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.CertAwayDao;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import org.springframework.stereotype.Service;

/**
 * @Auther: heibin
 * @Date: 2018/11/23 21:49
 * @Description:分发记录
 */
@Service
public class CertAwayDaoImpl implements CertAwayDao {
    /*
     * 新增分发记录表
     * @param certAwayDO
     * @return  Integer
     * @throws Exception
     */
    @Override
    public Integer insertCertAway(CertAwayDO certAwayDO) throws Exception {
        return EqlUtils.getInstance("DEFAULT").insert("insertCertAway").params(certAwayDO).returnType(Integer.class).execute();
    }
}
