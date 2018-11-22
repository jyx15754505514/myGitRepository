package com.ccicnavi.bims.product.api;

import com.ccicnavi.bims.product.pojo.CatalogOrgDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDTO;

import java.util.List;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:38
 */
public interface CatalogOrgService {

    /**组织机构与产品线关系查询*/
    List<CatalogOrgDO> listCatalogOrgDO(CatalogOrgDO catalogOrgDO)throws Exception;

    /**更新组织机构与产品线间的关系*/
    int updateCatalogOrgDO(CatalogOrgDTO catalogOrgDTO)throws Exception;

}
