package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.breeder.api.IdWorkerService;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.SpecialNeedService;
import com.ccicnavi.bims.customer.dao.SpecialNeedDao;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import com.ccicnavi.bims.customer.pojo.SpecialNeedDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author WangYingling
 * @Description 客户特殊需求信息ServiceImpl
 * @Date 19:59 2018/11/14
 */

@Service
@Slf4j
public class SpecialNeedServiceImpl implements SpecialNeedService {

    @Reference(timeout = 1000000)
    IdWorkerService idWorkerService;

    @Autowired
    SpecialNeedDao specialNeedDao;

    /**
     * @Author WangYingling
     * @Description 查询所有客户特殊需求信息
     * @Date 20:00 2018/11/14
     * @param specialNeed
     * @return java.util.List<com.ccicnavi.bims.customer.pojo.SpecialNeedDO>
     */
    @Override
    public List<SpecialNeedDO> listSpecialNeed(SpecialNeedDO specialNeed) {
        List<SpecialNeedDO> specialNeedList=null;
        try {
            specialNeedList=specialNeedDao.listSpecialNeed();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("查询客户特殊需求信息失败",e);
        }
        return specialNeedList;
    }

    /**
     * @Author WangYingling
     * @Description 新增客户特殊需求信息
     * @Date 20:00 2018/11/14
     * @param specialNeed
     * @return java.lang.Integer
     */
    @Override
    public int saveSpecialNeed(SpecialNeedDO specialNeed) {
        Integer count=0;
        try {
            String needUuid = idWorkerService.getId(new Date());
            specialNeed.setNeedUuid(needUuid);
            count=specialNeedDao.saveSpecialNeed(specialNeed);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("新增客户特殊需求信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 删除客户特殊需求信息
     * @Date 20:00 2018/11/14
     * @param needUuid
     * @return java.lang.Integer
     */
    @Override
    public int removeSpecialNeed(String needUuid) {
        Integer count=0;
        try {
            count=specialNeedDao.removeSpecialNeed(needUuid);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除客户特殊需求信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 修改客户特殊需求信息
     * @Date 20:00 2018/11/14
     * @param specialNeed
     * @return java.lang.Integer
     */
    @Override
    public int updateSpecialNeed(SpecialNeedDO specialNeed) {
        Integer count=0;
        try {
            count=specialNeedDao.updateSpecialNeed(specialNeed);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("修改客户特殊需求信息失败",e);
        }
        return count;
    }

    /**
     * @Author WangYingling
     * @Description 查询客户特殊需求信息（根据主键获取）
     * @Date 20:00 2018/11/14
     * @param specialNeed
     * @return com.ccicnavi.bims.customer.pojo.SpecialNeedDO
     */
    @Override
    public SpecialNeedDO getSpecialNeed(SpecialNeedDO specialNeed) {
        SpecialNeedDO specialNeedBean=null;
        try {
            specialNeedBean=specialNeedDao.getSpecialNeed(specialNeed);
        } catch (Exception e) {
            log.error("查询客户特殊需求信息失败",e);
            e.printStackTrace();
        }
        return specialNeedBean;
    }
    /**
     * @Author congzhiyuan
     * @Description 分页查询客户特殊需求信息
     * @Date 20:00 2018/11/14
     * @param pageParameter
     * @return PageBean
     */
    public PageBean<SpecialNeedDO> getSpecialNeedPage(PageParameter<SpecialNeedDO> pageParameter) {
        try {
            return specialNeedDao.getSpecialNeedPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询客户特殊需求信息出错",e);
        }
        return new PageBean<>(0,0,0,0,0,new ArrayList<SpecialNeedDO>());
    }
}
