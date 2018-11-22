package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.pojo.CatalogOrgDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDTO;
import com.ccicnavi.bims.product.service.CatalogOrgServiceImpl;
import org.junit.Test;

import java.util.List;

;


/**
 * @description:
 * @author: guojinxu
 * @create: 2018/11/21 17:41
 */
public class CatalogOrgServiceImplTest {
    @Test
    public void listCatalogOrgDO() {
        CatalogOrgServiceImpl catalogOrgService1 = new CatalogOrgServiceImpl();
        CatalogOrgDO catalogOrgDO = new CatalogOrgDO();
        catalogOrgDO.setOrganizationUuid("CCICDB");
        try {
            List<CatalogOrgDO> catalogOrgDOList = catalogOrgService1.listCatalogOrgDO(catalogOrgDO);
            System.out.println("--------"+catalogOrgDOList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void updateCatalogOrgDO() {
        CatalogOrgServiceImpl catalogOrgService = new CatalogOrgServiceImpl();
        CatalogOrgDTO catalogOrgDTO = new CatalogOrgDTO();
        catalogOrgDTO.setAppSysUuid("BIMS2.0");
        //catalogOrgDTO.setOrganizationUuid("CCICDB1");
        catalogOrgDTO.setProdCatalogUuid("CATALOG_AGM1");
        //String categoryUuidList = "";
        String orgUuidList = "";
        for(int i = 1;i<5;i++){
            orgUuidList += "CCICDB"+i+",";
        }
        catalogOrgDTO.setOrgUuidList(orgUuidList);
        try {
            int count = catalogOrgService.updateCatalogOrgDO(catalogOrgDTO);
            System.out.println("----------"+count);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}