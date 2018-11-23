package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
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
     * @Author FanDongSheng
     * @Description //TODO 查询指定分包方下的资质信息
     * @Date 17:58 2018/11/23
     * @Param [subcontractorDTO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubcQualifiDO>
     */
    @Override
    public List<SubcQualifiDO> listSubcQuali(SubcontractorDTO subcontractorDTO) {
        try {
           return subcQualifiDao.listSubcuQuali(subcontractorDTO);
        } catch (Exception e) {
            log.error("查询分包方资质信息失败",e);
        }
        return null;
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
            count=subcQualifiDao.insertSubcuQuali(subcQuali);
        } catch (Exception e) {
            log.error("新增分包方资质信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 删除分包方资质信息
     * @Date 20:00 2018/11/14
     * @param subcQuali
     * @return java.lang.Integer
     */
    @Override
    public int removeSubcQuali(SubcQualifiDO subcQuali) {
        Integer count=0;
        try {
            count=subcQualifiDao.removeSubcuQuali(subcQuali);
        } catch (Exception e) {
            log.error("删除分包方资质信息失败",e);
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
            log.error("修改分包方资质信息失败",e);
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
            log.error("查询分包方资质信息失败",e);
        }
        return subcQualifiBean;
    }
}
