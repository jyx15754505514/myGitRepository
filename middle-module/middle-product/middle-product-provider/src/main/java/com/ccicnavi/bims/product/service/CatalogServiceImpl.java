package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CatalogService;
import com.ccicnavi.bims.product.dao.CatalogDao;
import com.ccicnavi.bims.product.pojo.CatalogDO;
import com.ccicnavi.bims.product.pojo.CatalogOrgDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线信息ServiceImpl
 * @author: WangYingLing
 * @create: 2018-11-20 09:28
 */
@Service
@Slf4j
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogDao catalogDao;

    @Override
    public List<CatalogDO> listCatalogDO(CatalogDO catalogDO){
        try {
            return catalogDao.listCatalogDO();
        } catch (Exception e) {
            log.error("查询产品线信息失败",e);
            return null;
        }
    }

    @Override
    public int saveCatalogDO(CatalogDO catalogDO){
        try {
            return catalogDao.saveCatalogDO(catalogDO);
        } catch (Exception e) {
            log.error("新增产品线信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeCatalogDO(CatalogDO catalogDO){
        try {
            return catalogDao.removeCatalogDO(catalogDO);
        } catch (Exception e) {
            log.error("删除产品线信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateCatalogDO(CatalogDO catalogDO){
        try {
            return catalogDao.updateCatalogDO(catalogDO);
        } catch (Exception e) {
            log.error("修改产品线信息失败",e);
            return 0;
        }
    }

    @Override
    public CatalogDO getCatalogDO(CatalogDO catalogDO){
        try {
            return catalogDao.getCatalogDO(catalogDO);
        } catch (Exception e) {
            log.error("获取产品线信息失败",e);
            return null;
        }
    }

    @Override
    public PageBean<CatalogDO> listCatalogPage(PageParameter<CatalogDO> pageParameter) {
        try {
            return catalogDao.listCatalogPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品线信息失败",e);
            return null;
        }
    }

    @Override
    public List<CatalogDO> getCatalogThroughOrgUUid(CatalogOrgDO catalogOrgDO) {
        try {
            return catalogDao.getCatalogThroughOrgUUid(catalogOrgDO);
        } catch (Exception e) {
            log.error("根据组织机构id查询产品线信息失败");
            return null;
        }
    }

}
