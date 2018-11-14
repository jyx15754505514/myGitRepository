package com.ccicnavi.bims.resource.api;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import java.util.List;
/**
 * @Auther: fandongsheng
 * @Date: 2018/11/14 16:04
 * @Description:
 */
public interface CertPaperService {
    /**
     * 查询证书纸
     * @param certPaper
     * @return
     */
    List<CertPaperDO> listCertPaper(CertPaperDO certPaper) throws Exception;

    /**
     * 根据证书纸uuid查找单个证书纸信息
     * @param certPaper
     * @return
     */
    CertPaperDO getCertPaper(CertPaperDO certPaper) throws Exception;

    /**
     * 新增证书纸
     * @param certPaper
     * @return
     */
    Integer insertCertPaper(CertPaperDO certPaper) throws Exception;

    /**
     * 更新证书纸
     * @param certPaper
     * @return
     */
    Integer updateCertPaper(CertPaperDO certPaper) throws Exception;

    /**
     * 删除证书纸
     * @param certPaper
     * @return
     */
    Integer deleteCertPaper(CertPaperDO certPaper) throws Exception;
}
