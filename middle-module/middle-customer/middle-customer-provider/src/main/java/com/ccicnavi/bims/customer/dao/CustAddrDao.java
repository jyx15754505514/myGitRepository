package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.common.service.pojo.PageBean;
import com.ccicnavi.bims.common.service.pojo.PageParameter;
import com.ccicnavi.bims.customer.pojo.CustAddrDO;

import java.util.List;


public interface CustAddrDao {

    List<CustAddrDO> listCustAddr(CustAddrDO custAddr) throws Exception;

    int saveCustAddr(CustAddrDO custAddr) throws Exception;

    int removeCustAddr(CustAddrDO custAddr) throws Exception;

    int updateCustAddr(CustAddrDO custAddr) throws Exception;

    CustAddrDO getCustAddr(CustAddrDO custAddr) throws Exception;

    PageBean<CustAddrDO> listCustAddrPage(PageParameter<CustAddrDO> pageParameter) throws Exception;
}
