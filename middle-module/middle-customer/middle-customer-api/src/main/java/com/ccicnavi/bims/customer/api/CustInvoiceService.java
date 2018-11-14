package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;

import java.util.List;

/**
 * 客户发票接口层
 */
public interface CustInvoiceService {

    /**查询全部客户发票信息*/
    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) ;

    /**新增客户发票信息*/
    int saveCustInvoice(CustInvoiceDO custInvoice) ;

    /**删除客户发票信息*/
    int removeCustInvoice(String uuids);

    /**修改客户发票信息*/
    int updateCustInvoice(CustInvoiceDO custInvoice);

    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) ;
}
