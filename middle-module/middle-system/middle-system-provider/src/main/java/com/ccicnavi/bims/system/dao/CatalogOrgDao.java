package com.ccicnavi.bims.system.dao;

import com.ccicnavi.bims.system.pojo.CatalogOrgDO;
import org.n3r.eql.EqlTran;

import java.util.List;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 9:59
 */
public interface CatalogOrgDao {

    List<String> listCatalogOrgDO(CatalogOrgDO catalogOrgDO)throws Exception;

    int saveCatalogOrgDO(CatalogOrgDO catalogOrgDO, EqlTran eqlTran)throws Exception;

    int removeCatalogOrgDO(CatalogOrgDO catalogOrgDO, EqlTran eqlTran)throws Exception;

}
