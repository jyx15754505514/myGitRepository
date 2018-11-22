package com.ccicnavi.bims.product.test;


import com.ccicnavi.bims.product.pojo.CategoryOrgDO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;
import com.ccicnavi.bims.product.service.CategoryOrgServiceImpl;
import org.junit.Test;

import java.util.List;


/**
 * @description:
 * @author: guojinxu
 * @create: 2018/11/21 21:06
 */
public class CategoryOrgServiceImplTest {

    @Test
    public void listCategoryOrgDO() {
        CategoryOrgServiceImpl categoryOrgServiceTest = new CategoryOrgServiceImpl();
        CategoryOrgDO categoryOrgDO = new CategoryOrgDO();
        categoryOrgDO.setOrganizationUuid("XN102");
        List<CategoryOrgDO> categoryOrgDOList = categoryOrgServiceTest.listCategoryOrgDO(categoryOrgDO);
        System.out.println("-----------"+categoryOrgDOList);
    }

    @Test
    public void updateCategoryOrgDO() {
        CategoryOrgServiceImpl categoryOrgServiceTest = new CategoryOrgServiceImpl();
        CategoryOrgDTO categoryOrgDTO = new CategoryOrgDTO();
        categoryOrgDTO.setAppSysUuid("BIMS2.0");
        //categoryOrgDTO.setOrganizationUuid("XN1021");
        categoryOrgDTO.setProdCatalogUuid("CATALOG_AGRI3");
        String aaa = "";
        String bbb = "";
        for(int i = 3;i<5;i++){
            aaa += "gricultural_products_code"+i+",";
            bbb += "XN1021"+i+",";
            categoryOrgDTO.setCategoryUuidList(aaa);
            //categoryOrgDTO.setCatalogUuidList(bbb);
            categoryOrgDTO.setOrgUuidList(bbb);
        }

        int count = categoryOrgServiceTest.updateCategoryOrgDO(categoryOrgDTO);
        System.out.println("-------"+count);
    }
}