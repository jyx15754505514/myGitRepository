package com.ccicnavi.bims.resource.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.resource.api.CertAwayService;
import com.ccicnavi.bims.resource.dao.CertAwayDao;
import com.ccicnavi.bims.resource.dao.CertPaperDao;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
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
            certPaperDO.setStromNum((Integer.parseInt(getCertPaper.getStromNum())-Integer.parseInt(awayNum))+"");
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
            if(certPaperResult==1 && certAwayResult==1){
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
}
