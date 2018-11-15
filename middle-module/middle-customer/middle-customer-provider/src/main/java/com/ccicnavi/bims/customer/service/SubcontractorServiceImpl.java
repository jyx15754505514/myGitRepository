package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.SubcontractorService;
import com.ccicnavi.bims.customer.dao.SubcontractorDao;
import com.ccicnavi.bims.customer.pojo.SubcontractorDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Slf4j
public class SubcontractorServiceImpl implements SubcontractorService{

    @Autowired
    SubcontractorDao subcontractorDao;

    @Override
    public List<SubcontractorDO> listSubcontractor(SubcontractorDO subcontractor) {
        List<SubcontractorDO> subcontractorList=null;
        try {
            subcontractorList=subcontractorDao.listSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询分包方信息失败",e);
        }
        return subcontractorList;
    }

    @Override
    public int saveSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.saveSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("新增分包方信息失败",e);
        }
        return count;
    }

    @Override
    public int removeSubcontractor(String subcontractorUuid) {
        Integer count=0;
        try {
            count=subcontractorDao.removeSubcontractor(subcontractorUuid);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除分包方信息失败",e);
        }
        return count;
    }

    @Override
    public int updateSubcontractor(SubcontractorDO subcontractor) {
        Integer count=0;
        try {
            count=subcontractorDao.updateSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改分包方信息失败",e);
        }
        return count;
    }

    @Override
    public SubcontractorDO getSubcontractor(SubcontractorDO subcontractor) {
        SubcontractorDO subcontractorBean=null;
        try {
            subcontractorBean=subcontractorDao.getSubcontractor(subcontractor);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询分包方信息失败",e);
        }
        return subcontractorBean;
    }
}
