package com.ccicnavi.bims.resource.certPaper.service;
import com.ccicnavi.bims.resource.dao.impl.CertPaperDaoImpl;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/*
 * @Author:
 * @Description:   证书纸测试类
 * @Date:  2018/11/23  11:21
 * @Modified By:
 */
@Slf4j
public class CertPaperServiceImplTest {

    /*
     * 证书纸新增
     **/
    @Test
    public void insertCertPaper(){

        String a ="0001010";
        int b = Integer.parseInt(a);
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperStartNum("1001");
        certPaperDO.setPaperUuid("4");
        certPaperDO.setIsDeleted("N");
        certPaperDO.setPaperEndNum("1100");
        //流水起始号
        String paperStartNum =certPaperDO.getPaperStartNum();
        //流水截止号
        String paperEndNum=certPaperDO.getPaperEndNum();
        //入库数量
        certPaperDO.setStromNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum)+1)+"");
        //剩余数量默认等于入库数量
        certPaperDO.setResidualNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum)+1)+"");
        //当前号默认等于流水起始号
        certPaperDO.setCurrentCode(paperStartNum);
        //创建时间
        certPaperDO.setCreatedTime(new Date());
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
            log.error("新增证书纸失败",e);
        }

    }
    /*
     *编辑回显的时候用
     * 根据主键id查询证书纸对象
     **/
    @Test
    public void getCertPaper(){
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperUuid("4");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            CertPaperDO getCertPaper=certPaperDaoImpl.getCertPaper(certPaperDO);
            System.out.println(getCertPaper);
        } catch (Exception e) {
            log.error("根据uuid查询证书纸对象失败",e);
        }
    }
    /*
     *
     * 修改证书纸
     **/
    @Test
    public void updateCertPaper(){
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperStartNum("1001");
        certPaperDO.setPaperUuid("12");
        certPaperDO.setIsDeleted("N");
        certPaperDO.setPaperEndNum("1100");
        //流水起始号
        String paperStartNum =certPaperDO.getPaperStartNum();
        //流水截止号
        String paperEndNum=certPaperDO.getPaperEndNum();
        //入库数量
        certPaperDO.setStromNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum)+1)+"");
        //剩余数量默认等于入库数量
        certPaperDO.setResidualNum((Integer.parseInt(paperEndNum)-Integer.parseInt(paperStartNum)+1)+"");
        //当前号默认等于流水起始号
        certPaperDO.setCurrentCode(paperStartNum);
        //创建时间
        certPaperDO.setCreatedTime(new Date());
        certPaperDO.setStromDate(new Date());
        certPaperDO.setComments("这是新增的证书纸");
        certPaperDO.setProdCatalogUuid("111");
        certPaperDO.setOrgUuid("1111");
        certPaperDO.setAppSysUuid("1111");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            Integer result= certPaperDaoImpl.updateCertPaper(certPaperDO);
            System.out.println(result);
        } catch (Exception e) {
            log.error("修改证书纸失败",e);
        }

    }
    /*
     *
     * 删除证书纸
     **/
    @Test
    public void deleteCertPaper(){
        CertPaperDO certPaperDO =new CertPaperDO();
        certPaperDO.setPaperUuid("1");
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            Integer result=certPaperDaoImpl.deleteCertPaper(certPaperDO);
            System.out.println(result);
        } catch (Exception e) {
            log.error("删除证书纸失败",e);
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
            System.out.println(listCertPaper.size());
        } catch (Exception e) {
            log.error("查询证书纸失败",e);
        }
    }

}
