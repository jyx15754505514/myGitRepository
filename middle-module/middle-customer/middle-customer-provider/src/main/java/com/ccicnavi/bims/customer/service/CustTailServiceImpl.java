package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustTailService;
import com.ccicnavi.bims.customer.dao.CustTailDao;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
            log.error("查询客户跟踪信息失败~",e);
            return null;
        }
    }

    @Override
    public int saveCustTail(CustTailDO custTail) {
        try {
            return custTailDao.saveCustTail(custTail);
        } catch (Exception e) {
            log.error("保存客户跟踪信息失败~",e);
            return 0;
        }
    }

    @Override
    public int removeCustTail(String uuids) {
        try {
            return custTailDao.removeCustTail(uuids);
        } catch (Exception e) {
            log.error("删除客户跟踪信息失败~",e);
            return 0;
        }
    }

    @Override
    public int updateCustTail(CustTailDO custTail) {
        try {
            return custTailDao.updateCustTail(custTail);
        } catch (Exception e) {
            log.error("修改客户跟踪信息失败~",e);
            return 0;
        }
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTailDO) {
        try {
            return custTailDao.getCustTail(custTailDO);
        } catch (Exception e) {
            log.error("根据主键查询客户跟踪信息失败~",e);
            return null;
        }
    }
}
