package com.ccicnavi.bims.customer.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccicnavi.bims.customer.api.CustInvoiceService;
import com.ccicnavi.bims.customer.dao.CustInvoiceDao;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户发票基本操作
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
@Service
@Slf4j
public class CustInvoiceServiceImpl implements CustInvoiceService {

    @Autowired
    CustInvoiceDao custInvoiceDao;

    @Override
    public List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) {
        try {
            return custInvoiceDao.listCustInvoice(custInvoice);
        } catch (Exception e) {
            log.debug("查询客户发票失败",e);
            return null;
        }
    }

    @Override
    public int saveCustInvoice(CustInvoiceDO custInvoice) {
        try {
            return custInvoiceDao.saveCustInvoice(custInvoice);
        } catch (Exception e) {
            log.error("保存客户发票失败",e);
            return 0;
        }
    }

    @Override
    public int removeCustInvoice(String uuids) {
        try {
            return custInvoiceDao.removeCustInvoice(uuids);
        } catch (Exception e) {
            log.error("删除客户发票失败",e);
            return 0;
        }
    }

    @Override
    public int updateCustInvoice(CustInvoiceDO custInvoice) {
        try {
            return custInvoiceDao.updateCustInvoice(custInvoice);
        } catch (Exception e) {
            log.error("修改客户发票失败",e);
            return 0;
        }
    }

    @Override
    public CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoiceDO) {
        try {
            return custInvoiceDao.getCustInvoice(custInvoiceDO);
        } catch (Exception e) {
            log.error("根据主键查询客户发票信息失败~",e);
            return null;
        }
    }


}
