package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.SpecialNeedService;
import com.ccicnavi.bims.customer.dao.SpecialNeedDao;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
@Slf4j
public class SpecialNeedServiceImpl implements SpecialNeedService {

    @Autowired
    SpecialNeedDao specialNeedDao;

    @Override
    public List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed) {
        List<SpecialNeedDO> specialNeedList=null;
        try {
            specialNeedList=specialNeedDao.listSpecialNeed(specialNeed);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户特殊需求信息失败",e);
        }
        return specialNeedList;
    }

    @Override
    public int saveSpecialNeed(SpecialNeedDO specialNeed) {
        Integer count=0;
        try {
            count=specialNeedDao.saveSpecialNeed(specialNeed);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("新增客户特殊需求信息失败",e);
        }
        return count;
    }

    @Override
    public int removeSpecialNeed(String needUuid) {
        Integer count=0;
        try {
            count=specialNeedDao.removeSpecialNeed(needUuid);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户特殊需求信息失败",e);
        }
        return count;
    }

    @Override
    public int updateSpecialNeed(SpecialNeedDO specialNeed) {
        Integer count=0;
        try {
            count=specialNeedDao.updateSpecialNeed(specialNeed);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户特殊需求信息失败",e);
        }
        return count;
    }

    @Override
    public SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed) {
        SpecialNeedDO specialNeedBean=null;
        try {
            specialNeedBean=specialNeedDao.getSpecialNeed(specialNeed);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户特殊需求信息失败",e);
        }
        return specialNeedBean;
    }
}
