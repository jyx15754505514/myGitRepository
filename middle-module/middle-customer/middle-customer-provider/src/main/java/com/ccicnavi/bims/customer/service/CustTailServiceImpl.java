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
        List<CustTailDO> custTailList=null;
        try {
            custTailList=custTailDao.listCustTail(custTail);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户跟踪信息失败~",e);
        }
        return custTailList;
    }

    @Override
    public int saveCustTail(CustTailDO custTail) {
        Integer count=0;
        try {
            count= custTailDao.saveCustTail(custTail);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("保存客户跟踪信息失败~",e);
        }
        return count;
    }

    @Override
    public int removeCustTail(String uuids) {
        Integer count=0;
        try {
            count=custTailDao.removeCustTail(uuids);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户跟踪信息失败~",e);
        }
        return count;
    }

    @Override
    public int updateCustTail(CustTailDO custTail) {
        Integer count=0;
        try {
            count=custTailDao.updateCustTail(custTail);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户跟踪信息失败~",e);
        }
        return count;
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTailDO) {
        CustTailDO custTail=null;
        try {
            custTail=custTailDao.getCustTail(custTailDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("根据主键查询客户跟踪信息失败~",e);
        }
        return custTail;
    }
}
