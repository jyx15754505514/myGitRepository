package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.api.CustTailService;
import com.ccicnavi.bims.customer.dao.CustTailDao;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户跟踪信息基本操作
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class CustTailServiceImpl implements CustTailService {

    @Autowired
    CustTailDao custTailDao;


    @Override
    public List<CustTailDO> listCustTail(CustTailDO custTail) {
        try {
            return custTailDao.listCustTail(custTail);
        } catch (Exception e) {
            log.error("查询客户跟踪信息失败~", e);
            return null;
        }
    }

    @Override
    public int saveCustTail(CustTailDO custTail) {
        try {
            return custTailDao.saveCustTail(custTail,null);
        } catch (Exception e) {
            log.error("保存客户跟踪信息失败~", e);
            return 0;
        }
    }

    @Override
    public int removeCustTail(CustTailDO custTail) {
        try {
            return custTailDao.removeCustTail(custTail,null);
        } catch (Exception e) {
            log.error("删除客户跟踪信息失败~", e);
            return 0;
        }
    }

    @Override
    public int updateCustTail(CustTailDO custTail) {
        try {
            return custTailDao.updateCustTail(custTail,null);
        } catch (Exception e) {
            log.error("修改客户跟踪信息失败~", e);
            return 0;
        }
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTailDO) {
        try {
            return custTailDao.getCustTail(custTailDO);
        } catch (Exception e) {
            log.error("根据主键查询客户跟踪信息失败~", e);
            return null;
        }
    }

    @Override
    public PageBean<CustTailDO> listCustTailPage(PageParameter<CustTailDO> pageParameter) {
        try {
            return custTailDao.listCustTailPage(pageParameter);
        } catch (Exception e) {
            log.error("服务端客户跟踪分页查询失败");
            return null;
        }
    }
}
