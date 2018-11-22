package com.ccicnavi.bims.product.dao.Impl;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.dao.CatalogWorkhourDao;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDTO;
import org.n3r.eql.Eql;
import org.n3r.eql.EqlPage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线工时工资数据库交互
 * @author: LiJie
 * @create: 2018-11-19 20:17
 */
@Service
public class CatalogWorkhourDaoImpl implements CatalogWorkhourDao {


    @Override
    public List<CatalogWorkhourDO> listCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        return new Eql().select("listCatalogWorkhour").returnType(CatalogWorkhourDO.class).execute();
    }

    @Override
    public int saveCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        return new Eql().insert("insertCatalogWorkhour").params(catalogWorkhour).returnType(int.class).execute();
    }

    @Override
    public int removeCatalogWorkhour(CatalogWorkhourDTO catalogWorkhourDTO) {
        return new Eql().update("deleteCatalogWorkhour").params(catalogWorkhourDTO).returnType(int.class).execute();
    }

    @Override
    public int updateCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        return new Eql().update("updateCatalogWorkhour").params(catalogWorkhour).returnType(int.class).execute();
    }

    @Override
    public CatalogWorkhourDO getCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        return new Eql().selectFirst("getCatalogWorkhour").params(catalogWorkhour).returnType(CatalogWorkhourDO.class).execute();
    }

    @Override
    public PageBean<CatalogWorkhourDO> listCatalogWorkhourPage(PageParameter<CatalogWorkhourDO> pageParameter) {
        //封装分页参数
        EqlPage page = new EqlPage(pageParameter.getStartIndex(), pageParameter.getPageRows());
        //执行查询
        List<CatalogWorkhourDO> catalogWorkhourList = new Eql().select("listCatalogWorkhour").params(pageParameter.getParameter()).returnType(CatalogWorkhourDO.class).limit(page).execute();
        if(catalogWorkhourList != null) {
            return new PageBean<>(page.getTotalRows(),page.getTotalPages(),page.getCurrentPage(),page.getPageRows(),page.getStartIndex(),catalogWorkhourList);//封装分页
        }else {
            return null;
        }
    }
}
