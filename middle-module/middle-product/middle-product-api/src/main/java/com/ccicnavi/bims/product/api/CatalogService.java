package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CatalogDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */
public interface CatalogService {

    /**查询全部产品线信息*/
    List<CatalogDO> listCatalogDO() throws Exception;

    /**新增产品线信息*/
    int saveCatalogDO(CatalogDO catalogDO) throws Exception;

    /**删除产品线信息*/
    int removeCatalogDO(CatalogDO catalogDO) throws Exception;

    /**修改产品线信息*/
    int updateCatalogDO(CatalogDO catalogDO)throws Exception;

    /**根据主键获取产品线信息*/
    CatalogDO getCatalogDO(CatalogDO catalogDO)throws Exception;

    /**分页查询产品线信息*/
    PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter);

}
