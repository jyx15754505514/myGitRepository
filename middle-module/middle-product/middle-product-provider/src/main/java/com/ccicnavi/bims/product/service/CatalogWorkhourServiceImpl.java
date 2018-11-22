package com.ccicnavi.bims.product.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.product.api.CatalogWorkhourService;
import com.ccicnavi.bims.product.dao.CatalogWorkhourDao;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDO;
import com.ccicnavi.bims.product.pojo.CatalogWorkhourDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 产品线工时工资实现
 * @author: LiJie
 * @create: 2018-11-19 18:23
 */
@Service
@Slf4j
public class CatalogWorkhourServiceImpl implements CatalogWorkhourService {

    @Autowired
    CatalogWorkhourDao catalogWorkhourDao;

    @Override
    public List<CatalogWorkhourDO> listCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        try {
            return catalogWorkhourDao.listCatalogWorkhour(catalogWorkhour);
        } catch (Exception e) {
            log.error("查询产品线对应工时工资失败~", e);
            return null;
        }

    }

    @Override
    public int saveCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        try {
            return catalogWorkhourDao.saveCatalogWorkhour(catalogWorkhour);
        } catch (Exception e) {
            log.error("保存产品线对应工时工资失败~", e);
            return 0;
        }
    }

    @Override
    public int removeCatalogWorkhour(CatalogWorkhourDTO catalogWorkhourDTO) {
        try {
            if (!StringUtils.isEmpty(catalogWorkhourDTO.getProdCatalogUuid())) {
                catalogWorkhourDTO.setUuids(catalogWorkhourDTO.getProdCatalogUuid().split(","));
                return catalogWorkhourDao.removeCatalogWorkhour(catalogWorkhourDTO);
            }
        } catch (Exception e) {
            log.error("删除产品线对应工时工资失败~", e);
        }
        return 0;
    }

    @Override
    public int updateCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        try {
            return catalogWorkhourDao.updateCatalogWorkhour(catalogWorkhour);
        } catch (Exception e) {
            log.error("修改产品线对应工时工资失败~", e);
            return 0;
        }
    }

    @Override
    public CatalogWorkhourDO getCatalogWorkhour(CatalogWorkhourDO catalogWorkhour) {
        try {
            return catalogWorkhourDao.getCatalogWorkhour(catalogWorkhour);
        } catch (Exception e) {
            log.error("根据主键查询产品线对应工时工资失败~", e);
            return null;
        }
    }

    @Override
    public PageBean<CatalogWorkhourDO> listCatalogWorkhourPage(PageParameter<CatalogWorkhourDO> pageParameter) {
        try {
            return catalogWorkhourDao.listCatalogWorkhourPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询产品线对应工时工资失败~", e);
            return null;
        }
    }
}
