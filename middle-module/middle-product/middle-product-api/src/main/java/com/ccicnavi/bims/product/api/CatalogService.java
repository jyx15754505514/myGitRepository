package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.product.pojo.CatalogDO;

import java.util.List;

public interface CatalogService {

    List<CatalogDO> listCatalogDO();

    int saveCatalogDO(CatalogDO catalogDO);

    int removeCatalogDO(CatalogDO catalogDO);

    int updateCatalogDO(CatalogDO catalogDO);

    CatalogDO getCatalogDO(CatalogDO catalogDO);

}
