package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.product.pojo.CatalogOrgDO;

import java.util.List;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:59
 */
public interface CatalogOrgDao {

    List<CatalogOrgDO> listCatalogOrgDO(CatalogOrgDO catalogOrgDO)throws Exception;

    int saveCatalogOrgDO(CatalogOrgDO catalogOrgDO)throws Exception;

    int removeCatalogOrgDO(CatalogOrgDO catalogOrgDO)throws Exception;

}
