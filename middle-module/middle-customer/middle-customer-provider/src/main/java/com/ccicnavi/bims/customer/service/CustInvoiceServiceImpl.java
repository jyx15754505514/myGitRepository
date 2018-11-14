package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustInvoiceService;
import com.ccicnavi.bims.customer.dao.CustInvoiceDao;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class CustInvoiceServiceImpl implements CustInvoiceService {

    @Resource
    CustInvoiceDao custInvoiceDao;

    @Override
    public List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) {
        return custInvoiceDao.listCustInvoice(custInvoice);
    }

    @Override
    public int saveCustInvoice(CustInvoiceDO custInvoice) {
        return custInvoiceDao.saveCustInvoice(custInvoice);
    }

    @Override
    public int removeCustInvoice(String uuids) {
        return custInvoiceDao.removeCustInvoice(uuids);
    }

    @Override
    public int updateCustInvoice(CustInvoiceDO custInvoice) {
        return custInvoiceDao.updateCustInvoice(custInvoice);
    }

    @Override
    public CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) {
        return custInvoiceDao.getCustInvoice(custInvoice);
    }


}
