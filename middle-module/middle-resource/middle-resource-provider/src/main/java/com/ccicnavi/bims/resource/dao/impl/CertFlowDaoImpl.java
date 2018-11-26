package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.CertFlowDao;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: heibin
 * @Date: 2018/11/25 21:45
 * @Description:证书流水
 */
@Service
public class CertFlowDaoImpl implements CertFlowDao {

    /**
     * 新增证书流水
     * @param certFlowDO
     * @return  Integer
     * @throws Exception
     */
    @Override
    public Integer insertCertFlow(CertFlowDO certFlowDO) throws Exception {
        return new Eql().insert("insertCertFlow").params(certFlowDO).returnType(Integer.class).execute();
    }
    /**
     *作废流水号
     * @param certFlowDO
     * @return Integer
     * @throws Exception
     */
    @Override
    public Integer cancelCertFlow(CertFlowDO certFlowDO) throws Exception {
        return new Eql().update("cancelCertFlow").params(certFlowDO).returnType(Integer.class).execute();
    }
    /**
     *分页查询证书纸管理-证书流水列表
     * @param pageParameter
     * @return
     * @throws
     */
    @Override
    public PageBean<CertFlowDO> listCertFlowPage(PageParameter<CertFlowDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CertFlowDO> certFlowList = new Eql().select("listCertFlow").params(pageParameter.getParameter()).returnType(CertFlowDO.class).limit(page).execute();
        if(certFlowList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),certFlowList);
        }else {
            return null;
        }
    }
}
