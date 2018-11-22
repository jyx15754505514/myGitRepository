package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDTO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品工时工资接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CatalogWorkhourService {

    /**查询全部产品工时工资信息*/
    List<CatalogWorkhourDO> listCatalogWorkhour(CatalogWorkhourDO catalogWorkhour);

    /**新增产品工时工资信息*/
    int saveCatalogWorkhour(CatalogWorkhourDO catalogWorkhour);

    /**删除产品工时工资信息*/
    int removeCatalogWorkhour(CatalogWorkhourDTO catalogWorkhourDTO);

    /**修改产品工时工资信息*/
    int updateCatalogWorkhour(CatalogWorkhourDO catalogWorkhour);

    /**根据主键返回对应产品工时工资信息*/
    CatalogWorkhourDO getCatalogWorkhour(CatalogWorkhourDO catalogWorkhour);

    /**分页查询产品工时工资信息*/
    PageBean<CatalogWorkhourDO> listCatalogWorkhourPage(PageParameter<CatalogWorkhourDO> pageParameter);
    
}
