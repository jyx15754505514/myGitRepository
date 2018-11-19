package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustInvoiceDO;
import org.n3r.eql.EqlTran;

import java.util.List;

public interface CustInvoiceDao {


    /**
    *@Description: 客户发票信息查询(不分页)
    *@Param: custInvoice
    *@return: List<CustInvoiceDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    /**
    *@Description: 客户发票信息新增
    *@Param: custInvoice
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int saveCustInvoice(CustInvoiceDO custInvoice, EqlTran tran) throws Exception;

    /**
    *@Description: 客户发票信息删除
    *@Param: custInvoice
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int removeCustInvoice(CustInvoiceDO custInvoice,EqlTran tran) throws Exception;

    /**
    *@Description: 客户发票信息修改
    *@Param: custInvoice
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */
    int updateCustInvoice(CustInvoiceDO custInvoice,EqlTran tran) throws Exception;

    /**
    *@Description: 根据主键查询客户发票信息
    *@Param: custInvoice
    *@return: CustInvoiceDO
    *@Author: zqq
    *@date: 2018/11/19
    */

    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) throws Exception;

    /**
    *@Description: 查询客户发票信息(分页)
    *@Param: pageParameter
    *@return: PageBean<CustInvoiceDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    PageBean<CustInvoiceDO> listCustInvoicePage(PageParameter<CustInvoiceDO> pageParameter) throws Exception;
}
