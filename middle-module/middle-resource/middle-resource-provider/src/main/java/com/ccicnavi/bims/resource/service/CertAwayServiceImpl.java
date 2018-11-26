package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.api.CertAwayService;
import com.ccicnavi.bims.resource.dao.CertAwayDao;
import com.ccicnavi.bims.resource.dao.CertFlowDao;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/*
 * @Auther: heibin
 * @Date: 2018/11/23 20:51
 * @Description: 证书纸管理-分发记录表
 */
@Service
@Slf4j
public class CertAwayServiceImpl implements CertAwayService {
    @Autowired
    CertFlowDao certFlowDao;
    @Autowired
    CertAwayDao certAwayDao;
    @Autowired
    CertPaperDao certPaperDao;
    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;
    /*
     * 新增分发记录表
     * @param certAwayDO
     * @return Integer
     */
    @Override
    public ResultT insertCertAway(CertAwayDO certAwayDO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        Integer certPaperResult=null;
        Integer certAwayResult=null;
        Integer certFlowResult=null;
        boolean result=true;
        try {
            eqlTran.start();
            CertPaperDO certPaper =new CertPaperDO();
            certPaper.setPaperUuid(certAwayDO.getPaperUuid());
            //获取分发前证书纸对象信息
            CertPaperDO getCertPaper=certPaperDao.getCertPaper(certPaper);
            //分发数量
            String awayNum=certAwayDO.getAwayNum();
            CertPaperDO certPaperDO =new CertPaperDO();
            certPaperDO.setPaperUuid(certAwayDO.getPaperUuid());
            certPaperDO.setResidualNum((Integer.parseInt(getCertPaper.getResidualNum())-Integer.parseInt(awayNum))+"");
            certPaperDO.setCurrentCode(Integer.parseInt(getCertPaper.getCurrentCode())+(Integer.parseInt(awayNum))+"");
            certPaperResult=certPaperDao.updateCertPaper(certPaperDO);
            certAwayDO.setAwayUuid(idWorkerService.getId(new Date()));
            //分发前证书纸对象当前号也就是分发开始号
            certAwayDO.setStartNum(getCertPaper.getCurrentCode());
            //分号结束号
            certAwayDO.setEndNum(
                    Integer.parseInt(getCertPaper.getCurrentCode())+(Integer.parseInt(awayNum)-1)+""
            );
            certAwayResult=certAwayDao.insertCertAway(certAwayDO);
           //证书流水
            Integer startNum=Integer.parseInt(getCertPaper.getCurrentCode());
            Integer endNum=Integer.parseInt(getCertPaper.getCurrentCode())+(Integer.parseInt(awayNum)-1);
            for(int i=startNum;i<=endNum;i++){
                CertFlowDO certflowDO=new CertFlowDO();
                certflowDO.setFlowUuid(idWorkerService.getId(new Date()));
                certflowDO.setFlowNum(i+"");
                certflowDO.setEmptyCardStatus("N");
                certflowDO.setCreatedTime(new Date());
                certflowDO.setIsDeleted("N");
                //待完善
                certflowDO.setCreatedName("1");
                certflowDO.setCreatedUuid("1");
                certflowDO.setAppSysUuid("yewu2.0");
                certflowDO.setProdCatalogUuid("yewu2.0");
                certflowDO.setOrgUuid("yewu2.0");
                certFlowResult=certFlowDao.insertCertFlow(certflowDO);
                if(certFlowResult!=1){
                    result=false;
                }
            }
            if(certPaperResult==1 && certAwayResult==1 && result==true){
                eqlTran.commit();
                return ResultT.success();
            }
        } catch (Exception e) {
            log.error("分发失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
        return ResultT.failure(ResultCode.ADD_FAILURE);
    }
    /**
     * @Author heibin
     * @Description  证书纸管理-分发记录分页列表
     * @Date 22:42 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.resource.pojo.CertAwayDO>
     */
    @Override
    public PageBean<CertAwayDO> listCertAwayPage(PageParameter<CertAwayDO> pageParameter) {
        try {
            return certAwayDao.listCertAwayPage(pageParameter);
        } catch (Exception e) {
            log.error(" 证书纸管理-分发记录分页查询失败",e);
            return null;
        }
    }
    /*
     * 作废分发记录
     * @param certPaper
     * @return
     */
    @Override
    public Integer deleteCertAway(CertAwayDO certAwayDO) {
        try {
            return certAwayDao.deleteCertAway(certAwayDO);
        } catch (Exception e) {
            log.error("作废证书纸管理-分发记录失败",e);
        }
        return 0;
    }
}
