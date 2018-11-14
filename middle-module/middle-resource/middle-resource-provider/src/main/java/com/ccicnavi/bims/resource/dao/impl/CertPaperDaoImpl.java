package com.ccicnavi.bims.resource.dao.impl;

import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
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
        List<CertPaperDO> certPaperList = new ArrayList<>();
        try {
            EqlUtils.getInstance("druid").select("listCertPaper");
        } catch (Exception e) {
            log.debug("查询证书纸错误",e);
            e.printStackTrace();
        }
        return certPaperList;
    }

    /**
     * 新增证书纸信息
     * @param certPaper
     * @return
     * @throws Exception
     */
    @Override
    public Integer insertCertPaper(CertPaperDO certPaper){
        try {
            EqlUtils.getInstance("druid").insert("insertCertPaper");
        } catch (Exception e) {
            log.debug("新增证书纸",e);
            e.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param certPaper
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateCertPaper(CertPaperDO certPaper) throws Exception {
        return null;
    }

    @Override
    public Integer deleteCertPaper(CertPaperDO certPaper) throws Exception {
        return null;
    }

    @Override
    public CertPaperDO getCertPaper(CertPaperDO certPaper) throws Exception {
        return null;
    }
}
