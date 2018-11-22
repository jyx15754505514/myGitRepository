package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.product.api.CategoryOrgService;
import com.ccicnavi.bims.product.dao.CategoryOrgDao;
import com.ccicnavi.bims.product.pojo.CategoryOrgDO;
import com.ccicnavi.bims.product.pojo.CategoryOrgDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @description: 产品类别与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 11:35
 */
@Service
@Slf4j
public class CategoryOrgServiceImpl implements CategoryOrgService {

    @Autowired
    CategoryOrgDao categoryOrgDao;

    
    /**
     * @Author guojinxu
     * @Description  查询产品类别id
     * @Date 2018/11/21 13:58
     * @Param [categoryOrgDO]
     * @return java.util.List<com.ccicnavi.bims.product.pojo.CategoryOrgDO>
     **/
    @Override
    public List<CategoryOrgDO> listCategoryOrgDO(CategoryOrgDO categoryOrgDO) {
        try {
            return categoryOrgDao.listCategoryOrgDO(categoryOrgDO);
        } catch (Exception e) {
            log.error("查询产品类别id失败",e);
            return null;
        }
    }

    /**
     * @Author guojinxu
     * @Description 更新产品类别与组织关系
     * @Date 2018/11/21 13:58
     * @Param [categoryOrgDO]
     * @return int
     **/
    @Override
    public int updateCategoryOrgDO(CategoryOrgDTO categoryOrgDTO) {
        EqlTran eqlTran = new Eql("DEFAULT").newTran();
        eqlTran.start();
        boolean success = true ;
        try {
            int count = 0;
            CategoryOrgDO categoryOrgDO = new CategoryOrgDO();
            //以产品分类id进行更新
            if(categoryOrgDTO.getProductCategoryUuid() != null && !"".equals(categoryOrgDTO.getProductCategoryUuid())){
                categoryOrgDO.setProductCategoryUuid(categoryOrgDTO.getProductCategoryUuid());
                categoryOrgDao.removeCategoryOrgDO(categoryOrgDO,eqlTran);
                String[] orgUuidList = categoryOrgDTO.getOrgUuidList().split(",",-1);
                String[] catalogUuidList = categoryOrgDTO.getCatalogUuidList().split(",",-1);
                if(orgUuidList.length>0){
                    for(int i = 0;i<orgUuidList.length-1;i++){
                        CategoryOrgDO categoryOrgDO1 = new CategoryOrgDO();
                        categoryOrgDO1.setProductCategoryUuid(categoryOrgDTO.getProductCategoryUuid());
                        categoryOrgDO1.setAppSysUuid(categoryOrgDTO.getAppSysUuid());
                        categoryOrgDO1.setProdCatalogUuid(catalogUuidList[i]);
                        categoryOrgDO1.setOrganizationUuid(orgUuidList[i]);
                        count += categoryOrgDao.saveCategoryOrgDO(categoryOrgDO1,eqlTran);
                    }
                }
                if(orgUuidList.length-1 != count){
                    success=false;
                }
            }
            //以组织机构id进行更新
            if(categoryOrgDTO.getOrganizationUuid() != null && !"".equals(categoryOrgDTO.getOrganizationUuid())){
                categoryOrgDO.setOrganizationUuid(categoryOrgDTO.getOrganizationUuid());
                categoryOrgDao.removeCategoryOrgDO(categoryOrgDO,eqlTran);
                String[] catalogUuidList = categoryOrgDTO.getCatalogUuidList().split(",",-1);
                String[] categoryUuidList = categoryOrgDTO.getCategoryUuidList().split(",",-1);
                if(catalogUuidList.length>0){
                    for(int i = 0;i<catalogUuidList.length-1;i++){
                        CategoryOrgDO categoryOrgDO1 = new CategoryOrgDO();
                        categoryOrgDO1.setOrganizationUuid(categoryOrgDTO.getOrganizationUuid());
                        categoryOrgDO1.setAppSysUuid(categoryOrgDTO.getAppSysUuid());
                        categoryOrgDO1.setProdCatalogUuid(catalogUuidList[i]);
                        categoryOrgDO1.setProductCategoryUuid(categoryUuidList[i]);
                        count += categoryOrgDao.saveCategoryOrgDO(categoryOrgDO1,eqlTran);
                    }
                }
                if(catalogUuidList.length-1 != count){
                    success=false;
                }
            }
            //以产品线id进行更新
            if(categoryOrgDTO.getProdCatalogUuid() != null && !"".equals(categoryOrgDTO.getProdCatalogUuid())){
                categoryOrgDO.setProdCatalogUuid(categoryOrgDTO.getProdCatalogUuid());
                categoryOrgDao.removeCategoryOrgDO(categoryOrgDO,eqlTran);
                String[] orgUuidList = categoryOrgDTO.getOrgUuidList().split(",",-1);
                String[] categoryUuidList = categoryOrgDTO.getCategoryUuidList().split(",",-1);
                if(orgUuidList.length>0){
                    for(int i = 0;i<orgUuidList.length-1;i++){
                        CategoryOrgDO categoryOrgDO1 = new CategoryOrgDO();
                        categoryOrgDO1.setOrganizationUuid(orgUuidList[i]);
                        categoryOrgDO1.setAppSysUuid(categoryOrgDTO.getAppSysUuid());
                        categoryOrgDO1.setProdCatalogUuid(categoryOrgDTO.getProdCatalogUuid());
                        categoryOrgDO1.setProductCategoryUuid(categoryUuidList[i]);
                        count += categoryOrgDao.saveCategoryOrgDO(categoryOrgDO1,eqlTran);
                    }
                }
                if(orgUuidList.length-1 != count){
                    success=false;
                }
            }
            if(!success){
                eqlTran.rollback();
            }
            eqlTran.commit();
            return count;
        } catch (Exception e) {
            log.error("更新产品类别与组织关系失败",e);
            eqlTran.rollback();
            return 0;
        }finally {
            eqlTran.close();
        }
    }

}
