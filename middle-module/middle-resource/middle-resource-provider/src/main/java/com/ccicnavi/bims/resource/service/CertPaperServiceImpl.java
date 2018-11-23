package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.common.service.com.ccicnavi.bims.common.util.EqlUtils;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertPaperService;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * @Auther: fandongsheng
 * @Date: 2018/11/14 16:13
 * @Description:
 */
@Service
@Slf4j
public class CertPaperServiceImpl implements CertPaperService {
    @Autowired
    CertPaperDao certPaperDao;
    /*
     * 查询证书纸
     * @param certPaper
     * @return
     */
    @Override
    public List<CertPaperDO> listCertPaper(CertPaperDO certPaper) {
        try {
            return certPaperDao.listCertPaper(certPaper);
        } catch (Exception e) {
            log.debug("查询证书纸失败",e);
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 根据证书纸paperUuid找到证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public CertPaperDO getCertPaper(CertPaperDO certPaper) {
        try {
            return certPaperDao.getCertPaper(certPaper);
        } catch (Exception e) {
            log.debug("查询单条证书纸失败",e);
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 新增证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public Integer insertCertPaper(CertPaperDO certPaper) {
        try {
            //流水起始号
            String paperStartNum =certPaper.getPaperStartNum();
            //流水截止号
            String paperEndNum=certPaper.getPaperEndNum();
            //入库数量
            certPaper.setStromNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum))+"");
            //剩余数量默认等于入库数量
            certPaper.setResidualNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum))+"");
            //当前号默认等于流水起始号
            certPaper.setCurrentCode(paperStartNum);
            //创建时间
            certPaper.setCreatedTime(new Date());
            certPaper.setIsDeleted("N");
            //下边这几个是必填的除了传过来的createdUuid
            /*
            certPaper.setCreatedUuid();
            certPaperDO.setProdCatalogUuid("111");
            certPaperDO.setOrgUuid("1111");
            certPaperDO.setAppSysUuid("1111");*/
            return certPaperDao.insertCertPaper(certPaper);
        } catch (Exception e) {
            log.debug("新增证书纸失败",e);
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * 更新证书纸信息
     * @param certPaper
     * @return
     */
    @Override
    public Integer updateCertPaper(CertPaperDO certPaper) {
        try {
            //流水起始号
            String paperStartNum =certPaper.getPaperStartNum();
            //流水截止号
            String paperEndNum=certPaper.getPaperEndNum();
            //入库数量
            certPaper.setStromNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum))+"");
            //剩余数量默认等于入库数量
            certPaper.setResidualNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum))+"");
            //当前号默认等于流水起始号
            certPaper.setCurrentCode(paperStartNum);
            //创建时间
            certPaper.setCreatedTime(new Date());
            certPaper.setIsDeleted("N");
            //下边这几个是必填的除了传过来的createdUuid
            /*
            certPaper.setCreatedUuid();
            certPaperDO.setProdCatalogUuid("111");
            certPaperDO.setOrgUuid("1111");
            certPaperDO.setAppSysUuid("1111");*/
            return certPaperDao.updateCertPaper(certPaper);
        } catch (Exception e) {
            log.debug("更新证书纸失败",e);
            e.printStackTrace();
        }
        return 0;
    }

    /*
     * 删除证书纸
     * @param certPaper
     * @return
     */
    @Override
    public Integer deleteCertPaper(CertPaperDO certPaper) {
        try {
            return certPaperDao.deleteCertPaper(certPaper);
        } catch (Exception e) {
            log.debug("删除证书纸失败",e);
            e.printStackTrace();
        }
        return 0;
    }
    /*
     * 校验证书纸
     * @param certPaper
     * @return Boolean
     */
    @Override
    public Boolean checkCertPaper(CertPaperDO certPaper) {
        CertPaperDO certPaperDO = new CertPaperDO();
        boolean result=true;
        try {
            //查询所有的证书纸
            List<CertPaperDO> listCertPaper = certPaperDao.listCertPaper(certPaperDO);
           //传过来的流水起始号
            Integer paperStartNum=null;
            //传过来的流水结束号
            Integer paperEndNum=null;
            if(certPaper.getPaperStartNum()!=null){
                paperStartNum=Integer.parseInt(certPaper.getPaperStartNum());
            }
            if(certPaper.getPaperEndNum()!=null){
                paperEndNum=Integer.parseInt(certPaper.getPaperEndNum());
            }
            for(CertPaperDO c:listCertPaper){
                if(paperStartNum!=null){
                    if(paperStartNum>=Integer.parseInt(c.getPaperStartNum()) && paperStartNum<=Integer.parseInt(c.getPaperEndNum())){
                        result=false;
                        return result;
                    }
                }
                if(paperEndNum!=null){
                    if(paperEndNum>=Integer.parseInt(c.getPaperStartNum()) && paperEndNum<=Integer.parseInt(c.getPaperEndNum())){
                        result=false;
                        return result;
                    }
                }
            }
        } catch (Exception e) {
            log.debug("校验证书纸失败",e);
        }
        return result;
    }
    /*
     * @Author heibin
     * @Description  证书纸分页列表
     * @Date 17:02 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertPaperDO>
     */
    @Override
    public PageBean<CertPaperDO> listCertPaperPage(PageParameter<CertPaperDO> pageParameter) {
        try {
            return certPaperDao.listCertPaperPage(pageParameter);
        } catch (Exception e) {
            log.error(" 证书纸分页查询失败");
            return null;
        }
    }
}
