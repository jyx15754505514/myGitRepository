package com.ccicnavi.bims.product.test;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.Impl.CategoryDaoImpl;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import org.junit.Test;

import java.util.List;

public class CategoryDaoImplTest {


    CategoryDaoImpl categoryDaoImpl=new CategoryDaoImpl();

    @Test
    public void listCategory() {
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategory(new CategoryDO());
        System.out.println(categoryDOS);
    }

    @Test
    public void saveCategory() {
        CategoryDO categoryDO=new CategoryDO();
        categoryDO.setProductCategoryUuid("KC_MT_SM");
        categoryDO.setProductCategoryTypeUuid("PCT_GOODS");
        categoryDO.setParentCategoryUuid("KC_MT");
        categoryDO.setParentAllCategoryUuid("KC_MT,CATALOG_MINERAL");
        categoryDO.setCategoryName("瘦煤");
        categoryDO.setSeqNum("67");
        categoryDO.setProdCatalogUuid("CATALOG_MINERAL");//产品线
        categoryDO.setOrgUuid("CCIC");
        categoryDO.setAppSysUuid("BIMS2.0");
        int i = categoryDaoImpl.saveCategory(categoryDO);
        System.out.println("count:"+i);
    }

    @Test
    public void removeCategory() {

    }

    @Test
    public void updateCategory() {
        CategoryDO categoryDO=new CategoryDO();
        categoryDO.setProductCategoryUuid("KC_MT_SM");
        categoryDO.setProductCategoryTypeUuid("PCT_GOODS");
        categoryDO.setParentCategoryUuid("KC_MT");
        categoryDO.setParentAllCategoryUuid("KC_MT,CATALOG_MINERAL");
        categoryDO.setCategoryName("瘦煤被修改了~");
        categoryDO.setCategoryCode("67");
        categoryDO.setProdCatalogUuid("CATALOG_MINERAL");//产品线
        categoryDO.setOrgUuid("CCIC");
        categoryDO.setAppSysUuid("BIMS2.0");
        int i = categoryDaoImpl.updateCategory(categoryDO);
        System.out.println("count:"+i);
    }

    @Test
    public void getCategory() {
        CategoryDO categoryDO=new CategoryDO();
        categoryDO.setProductCategoryUuid("KC_MT");
        CategoryDO category = categoryDaoImpl.getCategory(categoryDO);
        System.out.println(category);
    }

    @Test
    public void listCategoryPage() {
        PageParameter<CategoryDO> pageParameter=new PageParameter<CategoryDO>();
        pageParameter.setStartIndex(1);
        pageParameter.setPageRows(2);
        pageParameter.setStartPage(1);
        PageBean<CategoryDO> categoryDOPageBean = categoryDaoImpl.listCategoryPage(pageParameter);
        System.out.println(categoryDOPageBean);
    }


    /**
     * 根据所属公司机构和业务线查询出一级分类(筛选不同产品服务种类)
     */
    @Test
    public void listCategoryFirstByOrgAndProd() {
        CategoryDO categoryDO=new CategoryDO();
        categoryDO.setProdCatalogUuid("CATALOG_MINERAL");//设置产品线——矿产
        categoryDO.setOrgUuid("CCIC");//设置公司机构
        categoryDO.setProductCategoryTypeUuid("PCT_GOODS");//设置产品分类
        categoryDO.setParentCategoryUuid("KC_MT");//设置上级产品分类UUID
        categoryDO.setAppSysUuid("BIMS2.0");
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategoryFirstByOrgAndProd(categoryDO);
        System.out.println(categoryDOS);
    }





}
