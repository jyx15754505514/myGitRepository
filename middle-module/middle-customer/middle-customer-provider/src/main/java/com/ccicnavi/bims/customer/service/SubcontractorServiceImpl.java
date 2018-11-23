package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
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
     * @Author FanDongSheng
     * @Description //TODO 分页查询分包方信息
     * @Date 16:16 2018/11/23
     * @Param [pageParameter]
     * @Return com.ccicnavi.bims.common.service.pojo.PageBean<com.ccicnavi.bims.customer.pojo.SubcontractorDO>
     */
    @Override
    public PageBean<SubcontractorDO> listSubcontractor(PageParameter<SubcontractorDO> pageParameter) {
        try {
            return subcontractorDao.listSubcontractor(pageParameter);
        } catch (Exception e) {
            log.error("分包方分页查询失败",e);
            return null;
        }
    }

    /**
     * @Author FanDongSheng
     * @Description //TODO 新增分包方信息
     * @Date 16:16 2018/11/23
     * @Param [subcontractor]
     * @Return java.lang.Integer
     */
    @Override
    public Integer insertSubcontractor(SubcontractorDO subcontractor) {
        try {
           return subcontractorDao.insertSubcontractor(subcontractor);
        } catch (Exception e) {
            log.error("Service层新增分包方信息失败",e);
            return  null;
        }
    }

    /**
     * @Author WangYingling
     * @Description 删除分包方信息
     * @Date 20:00 2018/11/14
     * @param subcontractor
     * @return java.lang.Integer
     */
    @Override
    public Integer removeSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.removeSubcontractor(subcontractor);
        } catch (Exception e) {
            log.error("Service层删除分包方信息失败",e);
            e.printStackTrace();
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
    public Integer updateSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.updateSubcontractor(subcontractor);
        } catch (Exception e) {
            log.error("Service层修改分包方信息失败",e);
            e.printStackTrace();
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
            log.error("Service层查询分包方信息失败",e);
            e.printStackTrace();
        }
        return subcontractorBean;
    }
}
