package com.ccicnavi.bims.resource.certPaper.service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.resource.dao.impl.CertPaperDaoImpl;
import com.ccicnavi.bims.resource.pojo.CertPaperDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/**
 * @Author:  heibin
 * @Description:   证书纸测试类
 * @Date:  2018/11/23  11:21
 * @Modified By:
 */
@Slf4j
public class CertPaperServiceImplTest {

    /**
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
    /**
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
    /**
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
    /**
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
    /**
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
    /**
     * 校验证书纸 流水起始号  流水结束号
     **/
    @Test
    public void  checkCertPaper(){
        CertPaperDO certPaper =new CertPaperDO ();
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        certPaper.setPaperStartNum("1000");
        certPaper.setPaperEndNum("1200");
        CertPaperDO certPaperDO = new CertPaperDO();
        boolean result=true;
        try {
            //查询所有的证书纸
            List<CertPaperDO> listCertPaper = certPaperDaoImpl.listCertPaper(certPaperDO);
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
                        //return result;
                    }
                }
                if(paperEndNum!=null){
                    if(paperEndNum>=Integer.parseInt(c.getPaperStartNum()) && paperEndNum<=Integer.parseInt(c.getPaperEndNum())){
                        result=false;
                      //  return result;
                    }
                }
            }
        } catch (Exception e) {
            log.error("校验证书纸失败",e);
        }
       // return result;

    }
    /**
     * 证书纸分页列表
     **/
    @Test
    public void listCertPaperPage(){
        CertPaperDaoImpl certPaperDaoImpl =new CertPaperDaoImpl();
        try {
            PageParameter<CertPaperDO> pageParameter = new PageParameter();
            CertPaperDO certPaperDO = new CertPaperDO();
            pageParameter.setStartIndex(1);
            pageParameter.setPageRows(2);
            pageParameter.setStartPage(1);
            certPaperDO.setAppSysUuid("yewu2.0");
            certPaperDO.setProdCatalogUuid("yewu2.0");
            certPaperDO.setOrgUuid("yewu2.0");
            PageBean<CertPaperDO> certPaperDOPageBean = certPaperDaoImpl.listCertPaperPage(pageParameter);
            System.out.println(certPaperDOPageBean);
        } catch (Exception e) {
            log.error("证书纸分页查询失败",e);
        }
    }

}
