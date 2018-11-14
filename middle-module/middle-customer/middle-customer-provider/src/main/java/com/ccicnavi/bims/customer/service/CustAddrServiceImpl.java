package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustAddrService;
import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import com.ccicnavi.bims.customer.pojo.CustomerDO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户地址
 */
@Service
@Slf4j
public class CustAddrServiceImpl implements CustAddrService {


    @Resource
    CustAddrDao custAddrDao;

    @Override
    public List<CustAddrDO> listCustAddr(CustAddrDO custAddr) {
        List<CustAddrDO> custAddrList=null;
        try {
              custAddrList=custAddrDao.listCustAddr(custAddr);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户地址失败",e);
        }
        return custAddrList;
    }

    @Override
    public int saveCustAddr(CustAddrDO custAddr) {
        Integer count=0;
        try {
            count=custAddrDao.saveCustAddr(custAddr);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("保存客户地址失败",e);
        }
        return count;
    }

    @Override
    public int removeCustAddr(String uuids) {
        Integer count=0;
        try {
            count=custAddrDao.removeCustAddr(uuids);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户地址失败",e);
        }
        return count;
    }

    @Override
    public int updateCustAddr(CustAddrDO custAddr) {
        Integer count=0;
        try {
            count=custAddrDao.updateCustAddr(custAddr);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户地址失败",e);
        }
        return count;
    }

    @Override
    public CustAddrDO getCustAddr(CustAddrDO custAddrDO) {
        CustAddrDO custAddr=null;
        try {
            custAddr=custAddrDao.getCustAddr(custAddrDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("根据主键查询客户地址失败",e);
        }
        return custAddr;
    }


}
