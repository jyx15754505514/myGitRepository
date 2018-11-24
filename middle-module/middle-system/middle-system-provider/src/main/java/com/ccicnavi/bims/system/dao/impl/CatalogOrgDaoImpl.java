package com.ccicnavi.bims.system.dao.impl;

import com.ccicnavi.bims.system.dao.CatalogOrgDao;
import com.ccicnavi.bims.system.pojo.CatalogOrgDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlTran;
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
    public List<String> listCatalogOrgDO(CatalogOrgDO catalogOrgDO) {
        return new Eql().select("listCatalogOrgDO").params(catalogOrgDO).returnType(String.class).execute();
    }

    @Override
    public int saveCatalogOrgDO(CatalogOrgDO catalogOrgDO, EqlTran eqlTran) {
        return new Eql().useTran(eqlTran).insert("saveCatalogOrgDO").params(catalogOrgDO).returnType(int.class).execute();
    }


    @Override
    public int removeCatalogOrgDO(CatalogOrgDO catalogOrgDO, EqlTran eqlTran) {
        return new Eql().useTran(eqlTran).delete("removeCatalogOrgDO").params(catalogOrgDO).returnType(int.class).execute();
    }

}
