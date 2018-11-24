package com.ccicnavi.bims.resource.certPaper.service;
import com.ccicnavi.bims.resource.dao.impl.CertPaperDaoImpl;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/*
 * @Author:
 * @Description:   证书纸测试类
 * @Date:  2018/11/23  11:21
 * @Modified By:
 */
public class CertPaperServiceImplTest {

    /*
     * 证书纸新增
     **/
    @Test
    public void insertCertPaper(){

        String a ="0001010";
        int b = Integer.parseInt(a);
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperStartNum("001");
        certPaperDO.setPaperUuid("12");
        certPaperDO.setIsDeleted("N");
        certPaperDO.setPaperEndNum("00100");
        certPaperDO.setStromNum("100");
        certPaperDO.setStromDate(new Date());
        certPaperDO.setComments("这是新增的证书纸");
        certPaperDO.setProdCatalogUuid("111");
        certPaperDO.setOrgUuid("1111");
        certPaperDO.setAppSysUuid("1111");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
        Integer result= certPaperDaoImpl.insertCertPaper(certPaperDO);
           System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*
     *编辑回显的时候用
     * 根据主键id查询证书纸对象
     **/
    @Test
    public void getCertPaper(){
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperUuid("1111");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            CertPaperDO getCertPaper=certPaperDaoImpl.getCertPaper(certPaperDO);
            System.out.println(getCertPaper);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /*
     *
     * 修改证书纸
     **/
    @Test
    public void updateCertPaper(){
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperStartNum("0011");
        certPaperDO.setPaperUuid("12");
        certPaperDO.setIsDeleted("N");
        certPaperDO.setPaperEndNum("001001");
        certPaperDO.setStromNum("1000");
        certPaperDO.setStromDate(new Date());
        certPaperDO.setComments("这是新增的证书纸1");
        certPaperDO.setProdCatalogUuid("1111");
        certPaperDO.setOrgUuid("11111");
        certPaperDO.setAppSysUuid("11111");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            Integer result= certPaperDaoImpl.updateCertPaper(certPaperDO);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /*
     *
     * 删除证书纸
     **/
    @Test
    public void deleteCertPaper(){
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperUuid("1111");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            Integer result=certPaperDaoImpl.deleteCertPaper(certPaperDO);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /*
     * 查询所有的证书纸
     **/
    @Test
    public void listCertPaper(){
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        CertPaperDO certPaper=new  CertPaperDO();
        try {
            List<CertPaperDO> listCertPaper=certPaperDaoImpl.listCertPaper(certPaper);
            System.out.println(listCertPaper);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
