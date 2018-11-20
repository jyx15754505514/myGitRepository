package com.ccicnavi.bims.product.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;

import java.util.List;

public interface CatalogWorkhourDao {
    List<CatalogWorkhourDO> listCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) throws Exception;

    int saveCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) throws Exception;

    int removeCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) throws Exception;

    int updateCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) throws Exception;

    CatalogWorkhourDO getCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) throws Exception;

    PageBean<CatalogWorkhourDO> listCatalogWorkhourPage(PageParameter<CatalogWorkhourDO> pageParameter) throws Exception;
}
