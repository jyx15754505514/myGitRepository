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

    /**
     * @description查询全部产品线信息
     * @return List<CatalogDO>
     */
    List<CatalogDO> listCatalogDO(CatalogDO catalogDO);

    /**
     * @description 新增产品线信息
     * @param catalogDO
     * @return int
     */
    int saveCatalogDO(CatalogDO catalogDO);

    /**
     * @description 删除产品线信息
     * @param catalogDO
     * @return int
     */
    int removeCatalogDO(CatalogDO catalogDO);

    /**
     * @description 修改产品线信息
     * @param catalogDO
     * @return int
     */
    int updateCatalogDO(CatalogDO catalogDO);

    /**
     * @description 根据主键获取产品线信息
     * @param catalogDO
     * @return CatalogDO
     */
    CatalogDO getCatalogDO(CatalogDO catalogDO);

    /**
     * @description 分页查询产品线信息
     * @param pageParameter
     * @return PageBean<CatalogDO>
     */
    PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter);

    //根据省级公司id获取产品线id
    CatalogDO getCatalogThroughOrgnUUid();

}
