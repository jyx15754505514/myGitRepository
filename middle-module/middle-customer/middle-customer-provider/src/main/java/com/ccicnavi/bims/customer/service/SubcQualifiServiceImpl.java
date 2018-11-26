package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.customer.api.SubcQualifiService;
import com.ccicnavi.bims.customer.dao.SubcQualifiDao;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDO;
import com.ccicnavi.bims.customer.pojo.SubcQualifiDTO;
import com.ccicnavi.bims.customer.pojo.SubcontractorDTO;
import lombok.extern.slf4j.Slf4j;
import org.n3r.eql.EqlTran;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
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

    @Reference(url = "dubbo://127.0.0.1:20880",timeout = 1000)
    IdWorkerService idWorkerService;
    /**
     * @Author FanDongSheng
     * @Description 查询指定分包方下的资质信息
     * @Date 17:58 2018/11/23
     * @Param [subcontractorDTO]
     * @Return java.util.List<com.ccicnavi.bims.customer.pojo.SubcQualifiDO>
     */
    @Override
    public List<SubcQualifiDO> listSubcQuali(SubcontractorDTO subcontractorDTO) {
        List<SubcQualifiDO> subcQualifiDOList = null;
        try {
            subcQualifiDOList =  subcQualifiDao.listSubcuQuali(subcontractorDTO);
        } catch (Exception e) {
            log.error("查询分包方资质信息失败",e);
        }
        return subcQualifiDOList;
    }

    /**
     * @Author WangYingling
     * @Description 新增分包方资质信息
     * @Date 20:00 2018/11/14
     * @param subcQuali
     * @return java.lang.Integer
     */
    @Override
    public Integer insertSubcQuali(SubcQualifiDO subcQuali) {
        Integer count=0;
        try {
            String subcQualifiUuid = idWorkerService.getId(new Date());
            subcQuali.setSubcQualifiUuid(subcQualifiUuid);
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
     * @param subcQualifiDTO
     * @return java.lang.Integer
     */
    @Override
    public Integer deleteSubcQuali(SubcQualifiDTO subcQualifiDTO, EqlTran eqlTran) {
        Integer count=0;
        try {
            count=subcQualifiDao.deleteSubcuQuali(subcQualifiDTO, eqlTran);
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
    public Integer updateSubcQuali(SubcQualifiDO subcQuali) {
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
