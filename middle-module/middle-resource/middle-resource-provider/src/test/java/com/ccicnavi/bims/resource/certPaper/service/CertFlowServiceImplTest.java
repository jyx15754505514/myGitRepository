package com.ccicnavi.bims.resource.certPaper.service;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.CertFlowDaoImpl;
import com.ccicnavi.bims.resource.pojo.CertFlowDO;
import com.ccicnavi.bims.resource.pojo.CertFlowDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;

/**
 * @Author:  heibin
 * @Description:   证书纸管理-证书流水测试类
 * @Date:  2018/11/26  11:05
 * @Modified By:
 */
@Slf4j
public class CertFlowServiceImplTest {
    CertFlowDaoImpl certFlowDaoImpl =new CertFlowDaoImpl();
    /**
     * 流水号作废
     **/
    @Test
    public void cancelCertFlow(){
        CertFlowDO certFlowDO =new CertFlowDO();
        certFlowDO.setFlowNum("1082");
        certFlowDO.setEmptyCardStatus("Y");
        certFlowDO.setReason("2");
        certFlowDO.setCancelUuid("1");
        certFlowDO.setCancelDate(new Date());

        try {
            Integer result=certFlowDaoImpl.cancelCertFlow(certFlowDO);
            System.out.println(result);
        } catch (Exception e) {
            log.error("作废流水号失败",e);
        }
    }
    /**
     * 证书流水分页
     **/
    @Test
    public void listCertFlowPage(){
        CertFlowDaoImpl certFlowDaoImpl=new CertFlowDaoImpl();
        try {
            PageParameter<CertFlowDO> pageParameter = new PageParameter();
            CertFlowDO certFlowDO = new CertFlowDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(2);
            pageParameter.setStartPage(1);
            certFlowDO.setAppSysUuid("yewu2.0");
            certFlowDO.setProdCatalogUuid("yewu2.0");
            certFlowDO.setOrgUuid("yewu2.0");
            PageBean<CertFlowDTO> certFlowDOPageBean = certFlowDaoImpl.listCertFlowPage(pageParameter);
            System.out.println(certFlowDOPageBean);
        } catch (Exception e) {
            log.error("证书流水分页查询失败",e);
        }
    }
}
