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

    /**
    *@Description: 查询客户发票信息(不分页)
    *@Param: custInvoice
    *@return: List<CustInvoiceDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    List<CustInvoiceDO> listCustInvoice(CustInvoiceDO custInvoice) ;

   /**
   *@Description: 新增客户发票信息
   *@Param: custInvoice
   *@return: int
   *@Author: zqq
   *@date: 2018/11/19
   */

    int saveCustInvoice(CustInvoiceDO custInvoice) ;

    /**
    *@Description: 删除客户发票信息
    *@Param: custInvoice
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int removeCustInvoice(CustInvoiceDO custInvoice);

    /**
    *@Description: 修改客户发票信息
    *@Param: custInvoice
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int updateCustInvoice(CustInvoiceDO custInvoice);

    /**
    *@Description: 根据主键查询客户发票信息
    *@Param: custInvoice
    *@return: CustInvoiceDO
    *@Author: zqq
    *@date: 2018/11/19
    */

    CustInvoiceDO getCustInvoice(CustInvoiceDO custInvoice) ;

    /**
    *@Description: 查询客户发票信息(分页)
    *@Param: pageParameter
    *@return: PageBean<CustInvoiceDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    PageBean<CustInvoiceDO> listCustInvoicePage(PageParameter<CustInvoiceDO> pageParameter);
}
