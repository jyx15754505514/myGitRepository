package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.dao.Impl.CatalogWorkhourDaoImpl;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;
import org.junit.Test;

import java.util.List;

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
        catalogWorkhourDO.setOrgUuid("CCIC");
        catalogWorkhourDO.setAppSysUuid("BIMS2.0");
        catalogWorkhourDaoImpl.saveCatalogWorkhour(catalogWorkhourDO);
    }

    @Test
    public void removeCatalogWorkhour() {
    }

    @Test
    public void updateCatalogWorkhour() {
        CatalogWorkhourDO catalogWorkhourDO=new CatalogWorkhourDO();
        catalogWorkhourDO.setOrganizationUuid("CCIC");
        catalogWorkhourDO.setProdCatalogUuid("BIMS2.0");
        catalogWorkhourDO.setSalaryWorkhour("8h");
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
    }
}
