package com.ccicnavi.bims.resource.certPaper.service;

import com.ccicnavi.bims.common.ResultCode;
import com.ccicnavi.bims.common.ResultT;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.CertAwayDaoImpl;
import com.ccicnavi.bims.resource.dao.impl.CertPaperDaoImpl;
import com.ccicnavi.bims.resource.pojo.CertAwayDO;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;

import java.util.Date;

/*
 * @Author:  heibin
 * @Description:   证书纸管理-分发记录测试类
 * @Date:  2018/11/25  11:37
 * @Modified By:
 */
@Slf4j
public class CertAwayServiceImplTest {
    /*
     * 分发记录新增
     **/
    @Test
    public void insertCertAway(){
        CertAwayDO certAwayDO =new CertAwayDO ();
        certAwayDO.setPaperUuid("4");
        certAwayDO.setAwayNum("50");
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        Integer certPaperResult=null;
        Integer certAwayResult=null;
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        CertAwayDaoImpl certAwayDaoImpl=new CertAwayDaoImpl();
        try {
            eqlTran.start();
            CertPaperDO certPaper =new CertPaperDO();
            certPaper.setPaperUuid(certAwayDO.getPaperUuid());
            //获取分发前证书纸对象信息
            CertPaperDO getCertPaper=certPaperDaoImpl.getCertPaper(certPaper);
            //分发数量
            String awayNum=certAwayDO.getAwayNum();
            CertPaperDO certPaperDO =new CertPaperDO();
            certPaperDO.setPaperUuid(certAwayDO.getPaperUuid());
            certPaperDO.setResidualNum((Integer.parseInt(getCertPaper.getResidualNum())-Integer.parseInt(awayNum))+"");
            certPaperDO.setCurrentCode(Integer.parseInt(getCertPaper.getCurrentCode())+(Integer.parseInt(awayNum))+"");
            certPaperResult=certPaperDaoImpl.updateCertPaper(certPaperDO);
            certAwayDO.setAwayUuid("4");
            //分发前证书纸对象当前号也就是分发开始号
            certAwayDO.setStartNum(getCertPaper.getCurrentCode());
            //分号结束号
            certAwayDO.setEndNum(
                    Integer.parseInt(getCertPaper.getCurrentCode())+(Integer.parseInt(awayNum)-1)+""
            );
            certAwayDO.setProdCatalogUuid("111");
            certAwayDO.setOrgUuid("1111");
            certAwayDO.setAppSysUuid("1111");
            certAwayResult=certAwayDaoImpl.insertCertAway(certAwayDO);
            if(certPaperResult==1 && certAwayResult==1){
                eqlTran.commit();
               // return ResultT.success();
            }
        } catch (Exception e) {
            log.error("分发失败",e);
            eqlTran.rollback();
        } finally {
            eqlTran.close();
        }
       // return ResultT.failure(ResultCode.ADD_FAILURE);


    }
    /*
     * 分发记录作废
     **/
    @Test
    public void deleteCertAway(){
        CertAwayDaoImpl certAwayDaoImpl=new CertAwayDaoImpl();
        CertAwayDO certAwayDO=new  CertAwayDO();
        certAwayDO.setAwayUuid("1");
        try {
            Integer result=certAwayDaoImpl.deleteCertAway(certAwayDO);
        } catch (Exception e) {
            log.error("作废证书纸管理-分发记录失败",e);
        }
    }
    /*
     * 分发记录分页
     **/
    @Test
    public void listCertAwayPage(){
        CertAwayDaoImpl certAwayDaoImpl=new CertAwayDaoImpl();
        try {
            PageParameter<CertAwayDO> pageParameter = new PageParameter();
            CertAwayDO certAwayDO = new CertAwayDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(2);
            pageParameter.setStartPage(1);
            certAwayDO.setAppSysUuid("yewu2.0");
            certAwayDO.setProdCatalogUuid("yewu2.0");
            certAwayDO.setOrgUuid("yewu2.0");
            PageBean<CertAwayDO> certAwayDOPageBean = certAwayDaoImpl.listCertAwayPage(pageParameter);
            System.out.println(certAwayDOPageBean);
        } catch (Exception e) {
            log.error("分发记录分页查询失败",e);
        }
    }
}
