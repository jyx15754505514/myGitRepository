package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.SubcontractorService;
import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author WangYingling
 * @Description 分包方信息ServiceImpl
 * @Date 19:59 2018/11/14
 */

@Service
@Slf4j
public class SubcontractorServiceImpl implements SubcontractorService{

    @Autowired
    SubcontractorDao subcontractorDao;

    /**
     * @Author WangYingling
     * @Description 查询所有分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractor
     * @return java.util.List<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        List<SubcontractorDO> subcontractorList=null;
        try {
            subcontractorList=subcontractorDao.listSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询分包方信息失败",e);
        }
        return subcontractorList;
    }

    /**
     * @Author WangYingling
     * @Description 新增分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractor
     * @return java.lang.Integer
     */
    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.saveSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增分包方信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 删除分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractorUuid
     * @return java.lang.Integer
     */
    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Integer count=0;
        try {
            count=subcontractorDao.removeSubcontractor(subcontractorUuid);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除分包方信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 修改分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractor
     * @return java.lang.Integer
     */
    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.updateSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改分包方信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 查询分包方信息（根据主键获取）
     * @Date 20:00 2018/11/14
     * @param subcontractor
     * @return com.ccicnavi.bims.customer.pojo.SubcontractorDO
     */
    @Override
    public SubcontractorDO getSubcontractor(SubcontractorDO subcontractor) {
        SubcontractorDO subcontractorBean=null;
        try {
            subcontractorBean=subcontractorDao.getSubcontractor(subcontractor);
        } catch (Exception e) {
            log.error("查询分包方信息失败",e);
            e.printStackTrace();
        }
        return subcontractorBean;
    }
}
