package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;

import java.util.List;

public interface CustInvoiceDao {


    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    int saveCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    int removeCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    int updateCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    PageBean<CustInvoiceDO> listCustInvoicePage(PageParameter<CustInvoiceDO> pageParameter) throws Exception;
}
