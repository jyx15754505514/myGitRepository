package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CatalogDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDO;

import java.util.List;

public interface CatalogDao {

    List<CatalogDO> listCatalog(CatalogDO catalogDO) throws Exception;

    int saveCatalog(CatalogDO catalogDO) throws Exception;

    int removeCatalog(CatalogDO catalogDO) throws Exception;

    int updateCatalog(CatalogDO catalogDO) throws Exception;

    CatalogDO getCatalog(CatalogDO catalogDO) throws Exception;

    PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter);

    List<CatalogDO> getCatalogByOrgUUid(CatalogOrgDO catalogOrgDO);

}
