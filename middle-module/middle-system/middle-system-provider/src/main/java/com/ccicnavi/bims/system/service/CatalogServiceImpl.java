package com.ccicnavi.bims.system.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.system.dao.CatalogDao;
import com.ccicnavi.bims.system.dao.impl.CatalogDaoImpl;
import com.ccicnavi.bims.system.pojo.CatalogDO;
import com.ccicnavi.bims.system.pojo.CatalogOrgDO;
import com.ccicnavi.bims.system.service.api.CatalogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
    static CatalogDao catalogDao;
    static {
        catalogDao = new CatalogDaoImpl();
    }
    @Reference(timeout = 1000000,url = "dubbo://192.168.125.11:20880")
    IdWorkerService idWorkerService;

    @Override
    public List<CatalogDO> listCatalog(CatalogDO catalogDO){
        try {
            return catalogDao.listCatalog();
        } catch (Exception e) {
            log.error("查询产品线信息失败",e);
            return null;
        }
    }

    @Override
    public int saveCatalog(CatalogDO catalogDO){
        try {
            return catalogDao.saveCatalog(catalogDO);
        } catch (Exception e) {
            log.error("新增产品线信息失败",e);
            return 0;
        }
    }

    @Override
    public int removeCatalog(CatalogDO catalogDO){
        try {
            return catalogDao.removeCatalog(catalogDO);
        } catch (Exception e) {
            log.error("删除产品线信息失败",e);
            return 0;
        }
    }

    @Override
    public int updateCatalog(CatalogDO catalogDO){
        try {
            return catalogDao.updateCatalog(catalogDO);
        } catch (Exception e) {
            log.error("修改产品线信息失败",e);
            return 0;
        }
    }

    @Override
    public CatalogDO getCatalog(CatalogDO catalogDO){
        try {
            String id = idWorkerService.getId(new Date());
            log.info("--------------"+id);
            return catalogDao.getCatalog(catalogDO);
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
    public List<CatalogDO> getCatalogByOrgUUid(CatalogOrgDO catalogOrgDO) {
        try {
            return catalogDao.getCatalogByOrgUUid(catalogOrgDO);
        } catch (Exception e) {
            log.error("根据组织机构id查询产品线信息失败");
            return null;
        }
    }

}
