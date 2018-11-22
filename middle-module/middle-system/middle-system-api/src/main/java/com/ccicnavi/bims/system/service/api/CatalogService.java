package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.pojo.CatalogDO;
import com.ccicnavi.bims.system.pojo.CatalogOrgDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线信息接口定义
 * @author: WangYingLing
 * @create: 2018-11-15 09:19
 */
public interface CatalogService {

    /**
     * @description查询全部产品线信息
     * @return List<CatalogDO>
     */
    List<CatalogDO> listCatalog(CatalogDO catalogDO);

    /**
     * @description 新增产品线信息
     * @param catalogDO
     * @return int
     */
    int saveCatalog(CatalogDO catalogDO);

    /**
     * @description 删除产品线信息
     * @param catalogDO
     * @return int
     */
    int removeCatalog(CatalogDO catalogDO);

    /**
     * @description 修改产品线信息
     * @param catalogDO
     * @return int
     */
    int updateCatalog(CatalogDO catalogDO);

    /**
     * @description 根据主键获取产品线信息
     * @param catalogDO
     * @return CatalogDO
     */
    CatalogDO getCatalog(CatalogDO catalogDO);

    /**
     * @description 分页查询产品线信息
     * @param pageParameter
     * @return PageBean<CatalogDO>
     */
    PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter);

    //根据省级公司id获取产品线id
    List<CatalogDO> getCatalogByOrgUUid(CatalogOrgDO catalogOrgDO);

}
