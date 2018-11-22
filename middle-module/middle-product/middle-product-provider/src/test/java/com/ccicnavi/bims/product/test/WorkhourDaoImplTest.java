package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.Impl.CatalogWorkhourDaoImpl;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;
import org.junit.Test;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线对应工时工资测试
 * @author: LiJie
 * @create: 2018-11-19 20:17
 */
public class WorkhourDaoImplTest {

    CatalogWorkhourDaoImpl catalogWorkhourDaoImpl=new CatalogWorkhourDaoImpl();

    @Test
    public void listCatalogWorkhour() {
        List<CatalogWorkhourDO> catalogWorkhourDOS = catalogWorkhourDaoImpl.listCatalogWorkhour(new CatalogWorkhourDO());
        System.out.println(catalogWorkhourDOS);
    }

    @Test
    public void saveCatalogWorkhour() {
        CatalogWorkhourDO catalogWorkhourDO=new CatalogWorkhourDO();
        catalogWorkhourDO.setOrganizationUuid("CCIC");
        catalogWorkhourDO.setProdCatalogUuid("BIMS2.0");
        catalogWorkhourDO.setSalaryWorkhour("1h/100");
        catalogWorkhourDO.setOrgUuid("CCIC");
        catalogWorkhourDO.setAppSysUuid("BIMS2.0");
        int i = catalogWorkhourDaoImpl.saveCatalogWorkhour(catalogWorkhourDO);
        System.out.println("count:"+i);
    }

    @Test
    public void removeCatalogWorkhour() {

    }

    @Test
    public void updateCatalogWorkhour() {
        CatalogWorkhourDO catalogWorkhourDO=new CatalogWorkhourDO();
        catalogWorkhourDO.setOrganizationUuid("CCIC");
        catalogWorkhourDO.setProdCatalogUuid("BIMS2.0");
        catalogWorkhourDO.setSalaryWorkhour("1h/1000000");
        catalogWorkhourDO.setOrgUuid("CCIC");
        catalogWorkhourDO.setAppSysUuid("BIMS2.0");
        int i = catalogWorkhourDaoImpl.updateCatalogWorkhour(catalogWorkhourDO);
        System.out.println("count:"+i);
    }

    @Test
    public void getCatalogWorkhour() {
        CatalogWorkhourDO catalogWorkhourDO=new CatalogWorkhourDO();
        catalogWorkhourDO.setOrganizationUuid("CCIC");
        catalogWorkhourDO.setProdCatalogUuid("BIMS2.0");
        CatalogWorkhourDO catalogWorkhour = catalogWorkhourDaoImpl.getCatalogWorkhour(catalogWorkhourDO);
        System.out.println(catalogWorkhour);
    }

    @Test
    public void listCatalogWorkhourPage() {
        PageParameter<CatalogWorkhourDO> pageParameter=new PageParameter<CatalogWorkhourDO>();
        pageParameter.setStartPage(1);
        pageParameter.setPageRows(2);
        pageParameter.setStartIndex(1);
        PageBean<CatalogWorkhourDO> catalogWorkhourDOPageBean = catalogWorkhourDaoImpl.listCatalogWorkhourPage(pageParameter);
        System.out.println(catalogWorkhourDOPageBean);
    }
}
