package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.n3r.eql.EqlTran;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/14 17:02
 * @Description:证书纸
 */
@Service
public class CertPaperDaoImpl implements CertPaperDao {
    /**
     * 查询证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public List<CertPaperDO> listCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("DEFAULT").select("listCertPaper").params(certPaper).returnType(CertPaperDO.class).execute();
    }

    /**
     * 新增证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer insertCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("DEFAULT").insert("insertCertPaper").params(certPaper).returnType(Integer.class).execute();
    }

    /**
     *更新证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer updateCertPaper(CertPaperDO certPaper, EqlTran tran) throws Exception{
        Eql eql = new Eql();
        if(tran != null){
            return eql.useTran(tran).update("updateCertPaper").params(certPaper).returnType(Integer.class).execute();
        }
        return eql.update("updateCertPaper").params(certPaper).returnType(Integer.class).execute();
    }
    /**
     *删除证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer deleteCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("DEFAULT").delete("deleteCertPaper").params(certPaper).returnType(Integer.class).execute();
    }
    /**
     *根据uuid查询证书纸信息对象
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public CertPaperDO getCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("DEFAULT").selectFirst("getCertPaper").params(certPaper).returnType(CertPaperDO.class).execute();
    }
    /**
     *分页查询证书纸列表
     * @param pageParameter
     * @return
     * @throws
     */
    @Override
    public PageBean<CertPaperDO> listCertPaperPage(PageParameter<CertPaperDO> pageParameter) throws Exception {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CertPaperDO> certPaperList = new Eql().select("listCertPaper").params(pageParameter.getParameter()).returnType(CertPaperDO.class).limit(page).execute();
        if(certPaperList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),certPaperList);
        }else {
            return null;
        }
    }

}
