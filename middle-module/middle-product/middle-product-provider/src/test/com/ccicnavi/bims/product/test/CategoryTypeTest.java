package com.ccicnavi.bims.product.test;

import com.ccicnavi.bims.product.dao.Impl.CategoryTypeDaoImpl;
import com.ccicnavi.bims.product.pojo.CategoryTypeDO;
import org.junit.Test;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 该类的作用描述
 * @author: 本人姓名
 * @create: 2018-11-20 14:29
 */
public class CategoryTypeTest {

    CategoryTypeDaoImpl categoryTypeDaoTest=new CategoryTypeDaoImpl();

    @Test
    public void lsitCategoryTypeDOTest(){
        List<CategoryTypeDO> categoryDOList=categoryTypeDaoTest.lsitCategoryTypeDO();
        System.out.println(categoryDOList);
    }

    @Test
    public void saveCategoryTypeDOTest(){
        for (int i=1;i<20;i++)
        {
            CategoryTypeDO categoryTypeDO=new CategoryTypeDO();
            categoryTypeDO.setProductCategoryTypeUuid("pctu_"+i);
            categoryTypeDO.setProdCatalogUuid("石化"+i+"线");
            categoryTypeDO.setOrgUuid("KM102");
            categoryTypeDO.setAppSysUuid(i+"号系统");
            int count=categoryTypeDaoTest.saveCategoryTypeDO(categoryTypeDO);
            System.out.println(count);
        }
    }

    @Test
    public void removeCategoryTypeDOTest(){
        CategoryTypeDO categoryTypeDO=new CategoryTypeDO();
        categoryTypeDO.setProductCategoryTypeUuid("pctu_10");
        int count=categoryTypeDaoTest.removeCategoryTypeDO(categoryTypeDO);
        System.out.println(count);
    }

    @Test
    public void updateCategoryTypeDOTest(){
        CategoryTypeDO categoryTypeDO=new CategoryTypeDO();
        categoryTypeDO.setProductCategoryTypeUuid("pctu_5");
        categoryTypeDO.setComments("备注被修改了");
        int count=categoryTypeDaoTest.updateCategoryTypeDO(categoryTypeDO);
        System.out.println(count);
    }

    @Test
    public void getCategoryTypeDOTest(){
        CategoryTypeDO categoryTypeDO=new CategoryTypeDO();;
        categoryTypeDO.setProductCategoryTypeUuid("pctu_9");
        CategoryTypeDO categoryTypeDOResult=categoryTypeDaoTest.getCategoryTypeDO(categoryTypeDO);
        System.out.println(categoryTypeDOResult);
    }

//    @Test
//    public void listCategoryTypePageDOTest(){
//
//    }

}
