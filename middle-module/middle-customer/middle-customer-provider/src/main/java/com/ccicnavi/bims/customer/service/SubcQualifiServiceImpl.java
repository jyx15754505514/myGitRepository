package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author WangYingling
 * @Description 分包方资质信息ServiceImpl
 * @Date 19:59 2018/11/14
 */

@Service
@Slf4j
public class SubcQualifiServiceImpl implements SubcQualifiService {

    @Autowired
    SubcQualifiDao subcQualifiDao;

    /**
     * @Author WangYingling
     * @Description 查询所有分包方资质信息
     * @Date 20:00 2018/11/14
     * @param subcQuali
     * @return java.util.List<com.ccicnavi.bims.customer.pojo.SubcQualifiDO>
     */
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

    /**
     * @Author WangYingling
     * @Description 新增分包方资质信息
     * @Date 20:00 2018/11/14
     * @param subcQuali
     * @return java.lang.Integer
     */
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

    /**
     * @Author WangYingling
     * @Description 删除分包方资质信息
     * @Date 20:00 2018/11/14
     * @param subcQualifiUuid
     * @return java.lang.Integer
     */
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

    /**
     * @Author WangYingling
     * @Description 修改分包方资质信息
     * @Date 20:00 2018/11/14
     * @param subcQuali
     * @return java.lang.Integer
     */
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

    /**
     * @Author WangYingling
     * @Description 查询分包方资质信息（根据主键获取）
     * @Date 20:00 2018/11/14
     * @param subcQuali
     * @return com.ccicnavi.bims.customer.pojo.SubcQualifiDO
     */
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
