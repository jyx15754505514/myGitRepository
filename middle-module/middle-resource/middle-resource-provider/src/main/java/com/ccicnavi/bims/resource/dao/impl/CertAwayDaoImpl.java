package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.CertAwayDao;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return new Eql().insert("insertCertAway").params(certAwayDO).returnType(Integer.class).execute();
    }
    /*
     *分页查询证书纸管理-分发记录列表
     * @param pageParameter
     * @return
     * @throws
     */
    @Override
    public PageBean<CertAwayDO> listCertAwayPage(PageParameter<CertAwayDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CertAwayDO> certPaperList = new Eql().select("listCertAway").params(pageParameter.getParameter()).returnType(CertAwayDO.class).limit(page).execute();
        if(certPaperList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),certPaperList);
        }else {
            return null;
        }
    }
    /*
     *作废证书纸管理-分发记录
     * @param certAwayDO
     * @return
     * @throws
     */
    @Override
    public Integer deleteCertAway(CertAwayDO certAwayDO) throws Exception {
        return EqlUtils.getInstance("DEFAULT").delete("deleteCertAway").params(certAwayDO).returnType(Integer.class).execute();
    }
}
