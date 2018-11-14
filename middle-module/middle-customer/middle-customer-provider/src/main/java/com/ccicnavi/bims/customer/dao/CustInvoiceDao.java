package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;

import java.util.List;

public interface CustInvoiceDao {


    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice);

    int saveCustInvoice(CustInvoiceDO custInvoice);

    int removeCustInvoice(String uuids);

    int updateCustInvoice(CustInvoiceDO custInvoice);

    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice);
}
