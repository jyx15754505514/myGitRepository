package com.ccicnavi.bims.customer.api;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;

import java.util.List;

/**
 * @program: bims-backend
 * @description: 客户发票接口定义
 * @author: LiJie
 * @create: 2018-11-15 09:19
 */
public interface CustInvoiceService {

    /**查询全部客户发票信息*/
    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) ;

    /**新增客户发票信息*/
    int saveCustInvoice(CustInvoiceDO custInvoice) ;

    /**删除客户发票信息*/
    int removeCustInvoice(CustInvoiceDO custInvoice);

    /**修改客户发票信息*/
    int updateCustInvoice(CustInvoiceDO custInvoice);

    /**根据主键查询客户发票信息*/
    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) ;

    /**分页查询客户发票信息*/
    PageBean<CustInvoiceDO> listCustInvoicePage(PageParameter<CustInvoiceDO> pageParameter);
}
