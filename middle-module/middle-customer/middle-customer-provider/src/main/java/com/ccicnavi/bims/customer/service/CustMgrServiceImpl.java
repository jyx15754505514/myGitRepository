package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustMgrService;
import com.ccicnavi.bims.customer.dao.CustMgrDao;
import com.ccicnavi.bims.customer.pojo.CustMgrDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: congzhiyuan
 * @Date: 2018/11/27 11:33
 * @Description: 客户跟进人管理
 * @Version 1.0
 */
@Slf4j
@Service
public class CustMgrServiceImpl implements CustMgrService {

    @Autowired
    CustMgrDao custMgrDao;
    /**
     * 功能描述: 获取客户所有跟进人
     * @param:
     * @return:
     * @date: 2018/11/27 11:34
     * @auther: congzhiyuan
     */
    @Override
    public List<CustMgrDO> listCustMgr(CustMgrDO custMgrDO) {
        try {
            return custMgrDao.listCustMgr(custMgrDO);
        } catch (Exception e) {
            log.error("查询客户跟进人出错", e);
            return null;
        }
    }
    /**
     * 功能描述: 分页获取客户跟进人
     * @param:
     * @return:
     * @date: 2018/11/27 11:34
     * @auther: congzhiyuan
     */
    @Override
    public PageBean<CustMgrDO> listCustMgrPage(PageParameter<CustMgrDO> pageParameter) {
        try {
            return custMgrDao.listCustMgrPage(pageParameter);
        } catch (Exception e) {
            log.error("分页查询客户跟进人出错",e);
        }
        return new PageBean<>(0,0,0,0,0,new ArrayList<CustMgrDO>());
    }
    /**
     * 功能描述: 添加客户跟进人
     * @param:
     * @return:
     * @date: 2018/11/27 11:34
     * @auther: congzhiyuan
     */
    @Override
    public int insertCustMgr(CustMgrDO custMgrDO) {
        try {
            return custMgrDao.insertCustMgr(custMgrDO);
        } catch (Exception e) {
            log.error("添加客户跟进人出错", e);
            return 0;
        }
    }
    /**
     * 功能描述: 删除客户跟进人
     * @param:
     * @return:
     * @date: 2018/11/27 11:34
     * @auther: congzhiyuan
     */
    @Override
    public int deleteCustMgr(CustMgrDO custMgrDO) {
        try {
            return custMgrDao.deleteCustMgr(custMgrDO);
        } catch (Exception e) {
            log.error("删除客户跟进人出错", e);
            return 0;
        }
    }

    /**
     * 功能描述: 获取客户跟进人详细信息
     * @param:
     * @return:
     * @date: 2018/11/27 11:34
     * @auther: congzhiyuan
     */
    @Override
    public CustMgrDO getCustMgr(CustMgrDO custMgrDO) {
        try {
            return custMgrDao.getCustMgr(custMgrDO);
        } catch (Exception e) {
            log.error("获取客户跟进人详细信息出错", e);
            return null;
        }
    }
}
