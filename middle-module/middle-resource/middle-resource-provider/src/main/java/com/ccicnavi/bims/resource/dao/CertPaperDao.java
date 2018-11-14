package com.ccicnavi.bims.resource.dao;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import java.util.List;

/**
 * @Auther: fandongsheng
 * @Date: 2018/11/14 16:53
 * @Description:
 */
public interface CertPaperDao {
    /**
     * 查询证书纸信息
     * @param certPaper
     * @return List<role>
     * @throws
     */
    public List<CertPaperDO> listCertPaper(CertPaperDO certPaper) ;

    /**
     * 新增证书纸
     * @param certPaper
     * @return Integer
     * @
     */
    public Integer insertCertPaper(CertPaperDO certPaper);

    /**
     * 更新证书纸信息
     * @param certPaper
     * @return Integer
     * @throws
     */
    public Integer updateCertPaper(CertPaperDO certPaper);

    /**
     * 删除证书纸信息
     * @param certPaper
     * @return Integer
     * @throws
     */
    public Integer deleteCertPaper(CertPaperDO certPaper);

    /**
     * 根据主键查询证书纸信息
     * @param certPaper
     * @return role
     * @throws
     */
    public CertPaperDO getCertPaper(CertPaperDO certPaper);
}
