package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.CatalogDao;
import com.ccicnavi.bims.product.pojo.CatalogDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线信息(prod_catalog)DaoImpl
 * @author: WangYingLing
 * @create: 2018-11-20 09:39
 */
@Service
public class CatalogDaoImpl implements CatalogDao {

    @Override
    public List<CatalogDO> listCatalog(CatalogDO catalogDO){
        return new Eql().select("listCatalogDO").params(catalogDO).returnType(CatalogDO.class).execute();
    }

    @Override
    public int saveCatalog(CatalogDO catalogDO){
        return new Eql().insert("saveCatalogDO").params(catalogDO).returnType(int.class).execute();
    }

    @Override
    public int removeCatalog(CatalogDO catalogDO){
        return new Eql().update("removeCatalogDO").params(catalogDO).returnType(int.class).execute();
    }

    @Override
    public int updateCatalog(CatalogDO catalogDO){
        return new Eql().update("updateCatalogDO").params(catalogDO).returnType(int.class).execute();
    }

    @Override
    public CatalogDO getCatalog(CatalogDO catalogDO){
        return new Eql().selectFirst("getCatalogDO").params(catalogDO).returnType(CatalogDO.class).execute();
    }

    @Override
    public PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CatalogDO> catalogList = new Eql().select("listCatalogDO").params(pageParameter.getParameter()).returnType(CatalogDO.class).limit(page).execute();
        if(catalogList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),catalogList);//封装分页
        }else {
            return null;
        }
    }

    @Override
    public List<CatalogDO> getCatalogByOrgUUid(CatalogOrgDO catalogOrgDO) {
        return new Eql().select("getCatalogThroughOrgUUid").params(catalogOrgDO).returnType(CatalogDO.class).execute();
    }
}
