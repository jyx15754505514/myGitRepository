package com.ccicnavi.bims.product.test;


import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.Impl.CategoryDaoImpl;
import com.ccicnavi.bims.product.pojo.CategoryDO;
import com.ccicnavi.bims.product.pojo.CategoryDTO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品分类测试
 * @author: LiJie
 * @create: 2018-11-19 20:17
 */
public class CategoryDaoImplTest {


    CategoryDaoImpl categoryDaoImpl=new CategoryDaoImpl();

    @Test
    public void listCategory() {
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategory(new CategoryDTO());
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
        CategoryDTO categoryDTO=new CategoryDTO();
        String [] uuids={"KC_MT","KC_MT_FM","KC_MT_JM"};
        categoryDTO.setUuids(uuids);
        int i = categoryDaoImpl.removeCategory(categoryDTO);
        System.out.println("count:"+i);
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
        categoryDO.setProductCategoryUuid("KC_MT_WYM");
        CategoryDO category = categoryDaoImpl.getCategory(categoryDO);
        System.out.println(category);
    }

    @Test
    public void listCategoryPage() {
        PageParameter<CategoryDTO> pageParameter=new PageParameter<CategoryDTO>();
        pageParameter.setStartIndex(1);
        pageParameter.setPageRows(2);
        pageParameter.setStartPage(1);
        PageBean<CategoryDO> categoryDOPageBean = categoryDaoImpl.listCategoryPage(pageParameter);
        System.out.println(categoryDOPageBean);
    }


    /**
     * 根据所属公司机构和业务线查询出一级分类(筛选不同产品服务种类)
     */
//    @Test
//    public void listCategoryFirstByOrgAndProd() {
//        CategoryDO categoryDO=new CategoryDO();
//        categoryDO.setProdCatalogUuid("CATALOG_MINERAL");//设置产品线——矿产
//        categoryDO.setOrgUuid("XN102");//设置公司机构
//        //categoryDO.setProductCategoryTypeUuid("PCT_GOODS");//设置产品分类
//        //categoryDO.setParentCategoryUuid("KC_MT");//设置上级产品分类UUID
//        categoryDO.setAppSysUuid("BIMS2.0");
//        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategoryFirstByOrgAndProd(categoryDO);
//        System.out.println(categoryDOS);
//    }


    @Test
    public void listCategoryFirstByOrgAndProd2() {
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setProdCatalogUuid("CATALOG_AGRI");//设置产品线——矿产
        categoryDTO.setOrganizationUuid("XN102");//设置公司机构
        categoryDTO.setProductCategoryTypeUuid("service_id");//设置产品分类
        categoryDTO.setParentCategoryUuid("gricultural_products_code");//设置上级产品分类UUID
        categoryDTO.setAppSysUuid("BIMS2.0");
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategoryFirstByOrgAndProd(categoryDTO);
        System.out.println(categoryDOS);
    }


    @Test
    public void listCategoryByParentUuid() {
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setProdCatalogUuid("CATALOG_AGRI");//设置产品线——矿产
        categoryDTO.setOrganizationUuid("XN102");//设置公司机构
        //categoryDTO.setProductCategoryTypeUuid("PCT_GOODS");//设置产品分类
        categoryDTO.setParentCategoryUuid("gricultural_products_code");//设置上级产品分类UUID
        categoryDTO.setOrgUuid("XN102");
        categoryDTO.setAppSysUuid("BIMS2.0");
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategoryByParentUuid(categoryDTO);
        System.out.println(categoryDOS);
    }

    @Test
    public void listCategoryByPage(){
        PageParameter<CategoryDTO> pageParameter =new PageParameter<CategoryDTO>();
        pageParameter.setPageRows(10);
        pageParameter.setStartPage(1);
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setCategoryName("二");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date parses = null;
        try {
            parses = sdf.parse("2018-11-22");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        categoryDTO.setCreatedTime(parses);
        pageParameter.setParameter(categoryDTO);
        PageBean<CategoryDO> categoryDOPageBean = categoryDaoImpl.listCategoryPage(pageParameter);
        System.out.println("分页信息如下："+categoryDOPageBean);
    }


    /**
     * 根据所属机构和产品线ID查询其所有子级分类信息(省级公司)
     */
    @Test
    public void findlistCategoryByOrgAndProdUuid(){
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setOrganizationUuid("XN102");
        categoryDTO.setAppSysUuid("BIMS2.0");
        categoryDTO.setProdCatalogUuid("CATALOG_MINERAL");
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategoryByOrgAndProd(categoryDTO);
        System.out.println(categoryDOS);
    }


    /***
     * 根据所属机构和产品线查询出其子级分类信息(子级公司)
     */
    @Test
    public void listCategorySubByOrgAndProd(){
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setOrganizationUuid("XN102");
        categoryDTO.setAppSysUuid("BIMS2.0");
        categoryDTO.setProdCatalogUuid("CATALOG_MINERAL");
        List<CategoryDO> categoryDOS = categoryDaoImpl.listCategorySubByOrgAndProd(categoryDTO);
        System.out.println(categoryDOS);
    }

    /**
     * 根据
     */


    /**
     * 根据所属机构和产品分类ID查询出其下的子级产品分类信息
     */
    @Test
    public void listCategoryOrgByOrgUuid(){
        CategoryOrgDTO categoryOrgDTO = new CategoryOrgDTO();
        categoryOrgDTO.setOrganizationUuid("XN102");
        categoryOrgDTO.setAppSysUuid("BIMS2.0");
        List<String> categoryOrgUuids = categoryDaoImpl.listCategoryOrgByOrgUuid(categoryOrgDTO);
        System.out.println(categoryOrgUuids);
    }

    /**
     * 根据多个产品分类的ID查询出对应的子级产品分类信息(区分公司)
     */
    @Test
    public void listCategoryByParentAllUuids(){
        CategoryOrgDTO categoryOrgDTO = new CategoryOrgDTO();
        categoryOrgDTO.setOrganizationUuid("XN102");
        categoryOrgDTO.setAppSysUuid("BIMS2.0");
        categoryOrgDTO.setProdCatalogUuid("CATALOG_MINERAL");
        List<String> list=new ArrayList<String>();
        list.add("energy_minerals_code");
        list.add("gricultural_products_code");
        System.out.println(list);
        //categoryOrgDO.setUuids(list);
        String uuidss="";
        for (int i = 0; i < list.size(); i++) {
            uuidss+=list.get(i)+"|";
        }
        uuidss=uuidss.substring(0,uuidss.length()-1);//截取掉最后一位特殊字符
        System.out.println();
        categoryOrgDTO.setCategoryUuidList(uuidss);
        List<CategoryDO> categoryOrgUuids=categoryDaoImpl.listCategoryByParentAllUuids(categoryOrgDTO);
        System.out.println("categoryOrgUuids:"+categoryOrgUuids);
    }


}
