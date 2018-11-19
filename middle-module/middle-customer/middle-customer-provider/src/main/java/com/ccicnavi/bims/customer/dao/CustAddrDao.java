package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;
import org.n3r.eql.EqlTran;

import java.util.List;


public interface CustAddrDao {

    /**
    *@Description: 客户地址查询列表
    *@Param: custAddr
    *@return:  List<CustAddrDO>
    *@Author: zqq
    *@date: 2018/11/19
    */

    List<CustAddrDO> listCustAddr(CustAddrDO custAddr) throws Exception;

    /**
    *@Description: 客户地址新增
    *@Param: custAddr
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int saveCustAddr(CustAddrDO custAddr, EqlTran tran) throws Exception;

    /**
    *@Description: 客户地址信息删除
    *@Param: custAddr
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int removeCustAddr(CustAddrDO custAddr,EqlTran tran) throws Exception;

    /**
    *@Description: 客户地址信息修改
    *@Param: custAddr
    *@return: int
    *@Author: zqq
    *@date: 2018/11/19
    */

    int updateCustAddr(CustAddrDO custAddr,EqlTran tran) throws Exception;

    /**
    *@Description: 根据主键获取客户地址信息
    *@Param: custAddr
    *@return: CustAddrDO
    *@Author: zqq
    *@date: 2018/11/19
    */

    CustAddrDO getCustAddr(CustAddrDO custAddr) throws Exception;

    /**
    *@Description: 查询客户地址信息(分页)
    *@Param: pageParameter
    *@return: PageBean<CustAddrDO>
    *@Author: 本人姓名
    *@date: 2018/11/19
    */

    PageBean<CustAddrDO> listCustAddrPage(PageParameter<CustAddrDO> pageParameter) throws Exception;
}
