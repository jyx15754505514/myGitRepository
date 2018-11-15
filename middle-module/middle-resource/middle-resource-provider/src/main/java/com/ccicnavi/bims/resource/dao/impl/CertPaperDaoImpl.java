package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import com.ccicnavi.bims.resource.pojo.SealDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return EqlUtils.getInstance("druid").select("listCertPaper").params(certPaper).returnType(CertPaperDO.class).execute();
    }

    /**
     * 新增证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer insertCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("druid").insert("insertCertPaper").params(certPaper).returnType(Integer.class).execute();
    }

    /**
     *更新证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer updateCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("druid").update("updateCertPaper").params(certPaper).returnType(Integer.class).execute();
    }

    @Override
    public Integer deleteCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("druid").delete("deleteCertPaper").params(certPaper).returnType(Integer.class).execute();
    }

    @Override
    public CertPaperDO getCertPaper(CertPaperDO certPaper) throws Exception{
        return EqlUtils.getInstance("druid").selectFirst("getCertPaper").params(certPaper).returnType(CertPaperDO.class).execute();
    }

}
