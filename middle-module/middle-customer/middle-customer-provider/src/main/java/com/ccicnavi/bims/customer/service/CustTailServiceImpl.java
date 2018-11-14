package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustTailService;
import com.ccicnavi.bims.customer.dao.CustTailDao;
import com.ccicnavi.bims.customer.pojo.CustTailDO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
public class CustTailServiceImpl implements CustTailService {

    CustTailDao custTailDao;

    @Override
    public List<CustTailDO> listCustTail(CustTailDO custTail) {
        return custTailDao.listCustTail(custTail);
    }

    @Override
    public int saveCustTail(CustTailDO custTail) {
        return custTailDao.saveCustTail(custTail);
    }

    @Override
    public int removeCustTail(String uuids) {
        return custTailDao.removeCustTail(uuids);
    }

    @Override
    public int updateCustTail(CustTailDO custTail) {
        return custTailDao.updateCustTail(custTail);
    }

    @Override
    public CustTailDO getCustTail(CustTailDO custTail) {
        return custTailDao.getCustTail(custTail);
    }
}
