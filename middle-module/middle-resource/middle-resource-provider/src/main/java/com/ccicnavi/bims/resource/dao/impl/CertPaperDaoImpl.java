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
 * @Description:
 */
@Service
@Slf4j
public class CertPaperDaoImpl implements CertPaperDao {
    /**
     * 查询证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public List<CertPaperDO> listCertPaper(CertPaperDO certPaper){
        try {
            return EqlUtils.getInstance("druid").select("listCertPaper").params(certPaper).returnType(SealDO.class).execute();
        } catch (Exception e) {
            log.debug("查询证书纸错误",e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 新增证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer insertCertPaper(CertPaperDO certPaper){
        try {
            return EqlUtils.getInstance("druid").insert("insertCertPaper").params(certPaper).returnType(SealDO.class).execute();
        } catch (Exception e) {
            log.debug("新增证书纸",e);
            e.printStackTrace();
        }
        return 0;
    }

    /**
     *更新证书纸信息
     * @param certPaper
     * @return
     * @throws
     */
    @Override
    public Integer updateCertPaper(CertPaperDO certPaper) {
        try {
            return EqlUtils.getInstance("druid").update("updateCertPaper").params(certPaper).returnType(SealDO.class).execute();
        } catch (Exception e) {
            log.debug("更新证书纸",e);
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer deleteCertPaper(CertPaperDO certPaper) {
        try {
            return EqlUtils.getInstance("druid").delete("deleteCertPaper").params(certPaper).returnType(SealDO.class).execute();
        } catch (Exception e) {
            log.debug("删除证书纸",e);
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public CertPaperDO getCertPaper(CertPaperDO certPaper) {
        try {
            return EqlUtils.getInstance("druid").selectFirst("getCertPaper").params(certPaper).returnType(SealDO.class).execute();
        } catch (Exception e) {
            log.debug("单条证书纸信息",e);
            e.printStackTrace();
        }
        return null;
    }
}
