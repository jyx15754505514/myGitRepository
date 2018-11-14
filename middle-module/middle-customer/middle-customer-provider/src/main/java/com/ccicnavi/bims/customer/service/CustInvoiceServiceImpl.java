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
        List<CustInvoiceDO> custInvoceList=null;
        try {
            custInvoceList=custInvoiceDao.listCustInvoice(custInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("查询客户发票失败",e);
        }
        return custInvoceList;
    }

    @Override
    public int saveCustInvoice(CustInvoiceDO custInvoice) {
        Integer count=0;
        try {
            count= custInvoiceDao.saveCustInvoice(custInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("保存客户发票失败",e);
        }
        return count;
    }

    @Override
    public int removeCustInvoice(String uuids) {
        Integer count=0;
        try {
            count=custInvoiceDao.removeCustInvoice(uuids);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("删除客户发票失败",e);
        }
        return count;
    }

    @Override
    public int updateCustInvoice(CustInvoiceDO custInvoice) {
        Integer count=0;
        try {
            count=custInvoiceDao.updateCustInvoice(custInvoice);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("修改客户发票失败",e);
        }
        return count;
    }

    @Override
    public CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoiceDO) {
        CustInvoiceDO custInvoice=null;
        try {
            custInvoice=custInvoiceDao.getCustInvoice(custInvoiceDO);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("根据主键查询客户发票信息失败~",e);
        }
        return custInvoice;
    }


}
