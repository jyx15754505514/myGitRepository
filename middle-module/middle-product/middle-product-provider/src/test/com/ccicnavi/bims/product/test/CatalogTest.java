package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.dao.Impl.CatalogDaoImpl;
import com.ccicnavi.bims.product.pojo.CatalogDO;
import org.junit.Test;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线信息测试
 * @author: WangYingLing
 * @create: 2018-11-20 14:28
 */
public class CatalogTest {

    CatalogDaoImpl catalogDaoTest=new CatalogDaoImpl();

    @Test
    public void listCatalogDOTest(){
        List<CatalogDO> catalogDOList=catalogDaoTest.listCatalogDO();
        System.out.println(catalogDOList);
    }

    @Test
    public void saveCatalogDOTest(){
        for (int i=1;i<20;i++)
        {
            CatalogDO catalogDO=new CatalogDO();
            catalogDO.setProdCatalogUuid("石化"+i+"线");
            catalogDO.setCreatedUuid("proc_"+i);
            catalogDO.setOrgUuid("XN102");
            catalogDO.setAppSysUuid(i+"号系统");
            int count=catalogDaoTest.saveCatalogDO(catalogDO);
            System.out.println(count);
        }
    }

    @Test
    public void removeCatalogDOTest(){
        CatalogDO catalogDO=new CatalogDO();
        catalogDO.setProdCatalogUuid("石化10线");
        int count=catalogDaoTest.removeCatalogDO(catalogDO);
        System.out.println(count);
    }

    @Test
    public void updateCatalogDOTest(){
        CatalogDO catalogDO=new CatalogDO();
        catalogDO.setProdCatalogUuid("石化5线");
        catalogDO.setComments("看见没，备注被改了");
        int count=catalogDaoTest.updateCatalogDO(catalogDO);
        System.out.println(count);
    }

    @Test
    public void getCatalogDOTest(){
        CatalogDO catalogDO=new CatalogDO();
        catalogDO.setProdCatalogUuid("石化9线");
        CatalogDO catalogDOResult=catalogDaoTest.getCatalogDO(catalogDO);
        System.out.println(catalogDOResult);
    }

//    @Test
//    public void listCatalogPageDOTest(){
//
//    }

}
