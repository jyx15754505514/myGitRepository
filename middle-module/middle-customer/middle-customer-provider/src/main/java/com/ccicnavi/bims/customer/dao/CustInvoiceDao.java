package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;

import java.util.List;

public interface CustInvoiceDao {


    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    int saveCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    int removeCustInvoice(String uuids) throws Exception;

    int updateCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) throws Exception;
}
