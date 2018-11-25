package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.resource.dao.CertFlowDao;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

/*
 * @Auther: heibin
 * @Date: 2018/11/25 21:45
 * @Description:证书流水
 */
@Service
public class CertFlowDaoImpl implements CertFlowDao {
    /*
     * 新增证书流水
     * @param certFlowDO
     * @return  Integer
     * @throws Exception
     */
    @Override
    public Integer insertCertFlow(CertFlowDO certFlowDO) throws Exception {
        return new Eql().insert("insertCertFlow").params(certFlowDO).returnType(Integer.class).execute();
    }
    /*
     *作废流水号
     * @param certFlowDO
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer cancelCertFlow(CertFlowDO certFlowDO) throws Exception {
        return new Eql().update("cancelCertFlow").params(certFlowDO).returnType(Integer.class).execute();
    }
}
