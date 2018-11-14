package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class SubcQualifiServiceImpl implements SubcQualifiService {

    @Autowired
    SubcQualifiDao subcQualifiDao;

    @Override
    public List<SubcQualifiDO> listSubcQuali(SubcQualifiDO subcQuali) {
        List<SubcQualifiDO> subcQualifiList=null;
        try {
            subcQualifiList=subcQualifiDao.listSubcuQuali(subcQuali);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询分包方资质信息失败",e);
        }
        return subcQualifiList;
    }

    @Override
    public int saveSubcQuali(SubcQualifiDO subcQuali) {
        Integer count=0;
        try {
            count=subcQualifiDao.saveSubcuQuali(subcQuali);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("新增分包方资质信息失败",e);
        }
        return count;
    }

    @Override
    public int removeSubcQuali(String subcQualifiUuid) {
        Integer count=0;
        try {
            count=subcQualifiDao.removeSubcuQuali(subcQualifiUuid);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除分包方资质信息失败",e);
        }
        return count;
    }

    @Override
    public int updateSubcQuali(SubcQualifiDO subcQuali) {
        Integer count=0;
        try {
            count=subcQualifiDao.updateSubcuQuali(subcQuali);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改分包方资质信息失败",e);
        }
        return count;
    }

    @Override
    public SubcQualifiDO getSubcQuali(SubcQualifiDO subcQuali) {
        SubcQualifiDO subcQualifiBean=null;
        try {
            subcQualifiBean=subcQualifiDao.getSubcQuali(subcQuali);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询分包方资质信息失败",e);
        }
        return subcQualifiBean;
    }
}
