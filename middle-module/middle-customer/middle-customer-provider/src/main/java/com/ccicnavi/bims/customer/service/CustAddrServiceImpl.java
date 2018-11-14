package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustAddrService;
import com.ccicnavi.bims.customer.dao.CustAddrDao;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
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
        return  custAddrDao.listCustAddr(custAddr);
    }

    @Override
    public int saveCustAddr(CustAddrDO custAddr) {
        return custAddrDao.saveCustAddr(custAddr);
    }

    @Override
    public int removeCustAddr(String uuids) {
        return custAddrDao.removeCustAddr(uuids);
    }

    @Override
    public int updateCustAddr(CustAddrDO custAddr) {
        return custAddrDao.updateCustAddr(custAddr);
    }

    @Override
    public CustAddrDO getCustAddr(CustAddrDO CustAddr) {
        return custAddrDao.getCustAddr(CustAddr);
    }


}
