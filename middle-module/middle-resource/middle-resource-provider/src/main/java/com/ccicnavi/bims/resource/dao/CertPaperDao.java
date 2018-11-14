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
     * @throws Exception
     */
    public List<CertPaperDO> listCertPaper(CertPaperDO certPaper) throws Exception;

    /**
     * 新增证书纸
     * @param certPaper
     * @return Integer
     * @throws Exception
     */
    public Integer insertCertPaper(CertPaperDO certPaper)throws  Exception;

    /**
     * 更新证书纸信息
     * @param certPaper
     * @return Integer
     * @throws Exception
     */
    public Integer updateCertPaper(CertPaperDO certPaper)throws Exception;

    /**
     * 删除证书纸信息
     * @param certPaper
     * @return Integer
     * @throws Exception
     */
    public Integer deleteCertPaper(CertPaperDO certPaper)throws Exception;

    /**
     * 根据主键查询证书纸信息
     * @param certPaper
     * @return role
     * @throws Exception
     */
    public CertPaperDO getCertPaper(CertPaperDO certPaper)throws Exception;
}
