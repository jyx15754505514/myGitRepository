package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.resource.api.CertPaperService;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/14 16:13
 * @Description:
 */
@Service
@Slf4j
public class CertPaperServiceImpl implements CertPaperService {
    @Reference
    CertPaperDao certPaperDao;
    /**
     * 查询证书纸
     * @param certPaper
     * @return
     */
    @Override
    public List<CertPaperDO> listCertPaper(CertPaperDO certPaper) {
        return certPaperDao.listCertPaper(certPaper);
    }

    /**
     * 根据证书纸paperUuid找到证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public CertPaperDO getCertPaper(CertPaperDO certPaper) {
        return certPaperDao.getCertPaper(certPaper);
    }

    /**
     * 新增证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public Integer insertCertPaper(CertPaperDO certPaper) {
       return certPaperDao.insertCertPaper(certPaper);
    }

    /**
     * 更新证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public Integer updateCertPaper(CertPaperDO certPaper) {
       return certPaperDao.updateCertPaper(certPaper);
    }

    /**
     * 删除证书纸
     * @param certPaper
     * @return
     */
    @Override
    public Integer deleteCertPaper(CertPaperDO certPaper) {
        return certPaperDao.deleteCertPaper(certPaper);
    }
}
