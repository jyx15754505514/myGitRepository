package com.ccicnavi.bims.system.service.api;

import com.ccicnavi.bims.system.pojo.CatalogOrgDO;
import com.ccicnavi.bims.system.pojo.CatalogOrgDTO;

import java.util.List;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:38
 */
public interface CatalogOrgService {

    /**组织机构与产品线关系查询*/
    List<String> listCatalogOrgDO(CatalogOrgDO catalogOrgDO);

    /**更新组织机构与产品线间的关系*/
    int updateCatalogOrgDO(CatalogOrgDTO catalogOrgDTO)throws Exception;

}
