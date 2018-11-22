package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.product.dao.CatalogOrgDao;
import com.ccicnavi.bims.product.pojo.CatalogOrgDO;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 产品线与组织机构关系
 * @author: guojinxu
 * @create: 2018/11/21 10:13
 */
@Service
public class CatalogOrgDaoImpl implements CatalogOrgDao {
    @Override
    public List<CatalogOrgDO> listCatalogOrgDO(CatalogOrgDO catalogOrgDO) {
        return new Eql().select("listCatalogOrgDO").params(catalogOrgDO).returnType(CatalogOrgDO.class).execute();
    }

    @Override
    public int saveCatalogOrgDO(CatalogOrgDO catalogOrgDO) {
        return new Eql().insert("saveCatalogOrgDO").params(catalogOrgDO).returnType(int.class).execute();
    }


    @Override
    public int removeCatalogOrgDO(CatalogOrgDO catalogOrgDO) {
        return new Eql().delete("removeCatalogOrgDO").params(catalogOrgDO).returnType(int.class).execute();
    }

}
