package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CatalogDO;

import java.util.List;

public interface CatalogDao {

    List<CatalogDO> listCatalogDO() throws Exception;

    int saveCatalogDO(CatalogDO catalogDO) throws Exception;

    int removeCatalogDO(CatalogDO catalogDO) throws Exception;

    int updateCatalogDO(CatalogDO catalogDO) throws Exception;

    CatalogDO getCatalogDO(CatalogDO catalogDO) throws Exception;

    PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter);

    CatalogDO getCatalogThroughOrgnUUid();

}
