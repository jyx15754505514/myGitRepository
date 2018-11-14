package com.ccicnavi.bims.customer.dao;

import com.ccicnavi.bims.customer.pojo.CustAddrDO;

import java.util.List;

public interface CustAddrDao {

    List<CustAddrDO> listCustAddr(CustAddrDO custAddr);

    int saveCustAddr(CustAddrDO custAddr);

    int removeCustAddr(String uuids);

    int updateCustAddr(CustAddrDO custAddr);

    CustAddrDO getCustAddr(CustAddrDO customer);
}
